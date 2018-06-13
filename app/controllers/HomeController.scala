package controllers

import java.io.File
import java.nio.file.{Files, Path}

import javax.inject._
import akka.stream.IOResult
import akka.stream.scaladsl._
import akka.util.ByteString
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.streams._
import play.api.mvc.MultipartFormData.FilePart
import play.api.mvc._
import org.apache.commons.io.{FileUtils, IOUtils}
import org.apache.commons.io.filefilter.TrueFileFilter
import play.core.parsers.Multipart.FileInfo

import scala.concurrent.{ExecutionContext, Future}

case class FormData(name: String)
case class FileMetaData(fileName:String,directory : String,size : Long, createdDate : String)
/**
 * This controller handles a file upload.
 */
@Singleton
class HomeController @Inject() (cc:MessagesControllerComponents)
                               (implicit executionContext: ExecutionContext)
  extends MessagesAbstractController(cc) {

  private val logger = Logger(this.getClass)

  val form = Form(
    mapping(
      "name" -> text
    )(FormData.apply)(FormData.unapply)
  )

  /**
   * Renders a start page.
   */
  def index = Action { implicit request =>
    Ok(views.html.index(form))
  }

  type FilePartHandler[A] = FileInfo => Accumulator[ByteString, FilePart[A]]

  /**
   * Uses a custom FilePartHandler to return a type of "File" rather than
   * using Play's TemporaryFile class.  Deletion must happen explicitly on
   * completion, rather than TemporaryFile (which uses finalization to
   * delete temporary files).
   *
   * @return
   */
  private def handleFilePartAsFile: FilePartHandler[File] = {
    case FileInfo(partName, filename, contentType) =>
      val path: Path = Files.createTempFile("multipartBody", "tempFile")
      val fileSink: Sink[ByteString, Future[IOResult]] = FileIO.toPath(path)
      val accumulator: Accumulator[ByteString, IOResult] = Accumulator(fileSink)
      accumulator.map {
        case IOResult(count, status) =>
          logger.info(s"count = $count, status = $status")
          FilePart(partName, filename, contentType, path.toFile)
      }
  }

  /**
   * A generic operation on the temporary file that deletes the temp file after completion.
   */
  private def operateOnTempFile(file: File) = {
    val size = Files.size(file.toPath)
    logger.info(s"size = ${size}")
    Files.deleteIfExists(file.toPath)
    size
  }

  /**
   * Uploads a multipart file as a POST request.
   *
   * @return
   */


  //package crypto.cbc

  import java.security.SecureRandom

  //package utils
  import javax.crypto.spec.SecretKeySpec
  import javax.crypto.Cipher
  import org.apache.commons.codec.binary.Hex
  import play.Logger
  import play.Play
  import java.security.MessageDigest

  object Blowfish {
    val cryptType = "Blowfish"
    import java.security.MessageDigest

    def md5(s: String) = {
      MessageDigest.getInstance("MD5").digest(s.getBytes)
    }
    def makeKey(key:String):String ={
      md5(key)
    }
                                                                          // COMMENT OUT ENCRYPTION DECRYPTION PART // THIS IS NOT IMPLEMENTED //
    def encrypt(text: String,key:String): String = {
      val sksSpec = new SecretKeySpec(makeKey(key).getBytes("UTF-8"), cryptType)
      var cipher = Cipher.getInstance(cryptType)
      cipher.init(Cipher.ENCRYPT_MODE, sksSpec)
      var encrypted = cipher.doFinal(text.getBytes())
      return String.valueOf(Hex.encodeHex(encrypted))
    }
    def decrypt(text: String,key:String): String = {
      var encrypted: Array[Byte] = null
      try {
        encrypted = Hex.decodeHex(text.toCharArray())
      } catch {
        case e: Throwable => {
          throw e
        }
      }
      val sksSpec = new SecretKeySpec(makeKey(key).getBytes("UTF-8"), cryptType)
      var cipher = Cipher.getInstance(cryptType)
      cipher.init(Cipher.DECRYPT_MODE, sksSpec)
      var decrypted = cipher.doFinal(encrypted)
      return new String(decrypted)
    }
  }

  //IF YOU WANT TO USE THIS, USE THE ABOVE FUNCTIONS ON UPLOAD AND DOWNLOAD PART//

  def upload = Action(parse.multipartFormData(handleFilePartAsFile)) { implicit request =>
    var fileMetadatas : Array[FileMetaData] = null;
    val fileOption = request.body.file("name").map {
      case FilePart(key, filename, contentType, file) =>
        var byte_arr : Array[Byte] = IOUtils.toByteArray(file.toURI)
       // println("byte_array "+new String(byte_arr,"utf-8"))
        println("content_length "+byte_arr.length)
        println(s"key = ${key}, filename = ${filename}, contentType = ${contentType}, file = $file")
        logger.info(s"key = ${key}, filename = ${filename}, contentType = ${contentType}, file = $file")
        var uploadDir  = "/home/rahul/Desktop/rahul_project/public/Uploads/"
        var relDir = "/assets/Uploads/"
        var f = new File(uploadDir+filename)
        if(!f.exists())f.createNewFile();
        var dir = new File(uploadDir)
        FileUtils.copyFile(new File(file.toString),f)
        var files : java.util.List[File] =   FileUtils.listFiles(dir,TrueFileFilter.INSTANCE,TrueFileFilter.INSTANCE).asInstanceOf[java.util.LinkedList[File]]
        fileMetadatas  = new Array[FileMetaData](files.size())
        var i = 0 ;
        files.forEach(f=> {
          fileMetadatas(i) = new FileMetaData(f.getName,relDir+f.getName,FileUtils.sizeOf(f),new java.util.Date().toString)

          //println("filename : " + fileMetadatas(i) )
          i = i+1

        })
        println("size "+files.size())
        fileMetadatas.foreach(f=>println("filename: "+f.fileName+" directory path: "+f.directory+" file size: "+f.size)+" create date : "+f.createdDate)
    }

    //Ok(s"file size = ${fileOption.getOrElse("no file")}")

    Ok(views.html.download(fileMetadatas))
  }

  def download = Action { implicit request =>
    var uploadDir  = "/home/rahul/Desktop/rahul_project/public/Uploads/"
    var relDir = "/assets/Uploads/"
    var dir = new File(uploadDir)
    var files : java.util.List[File] =   FileUtils.listFiles(dir,TrueFileFilter.INSTANCE,TrueFileFilter.INSTANCE).asInstanceOf[java.util.LinkedList[File]]
    var fileMetadatas : Array[FileMetaData] = new Array[FileMetaData](files.size())
    var i = 0 ;
    files.forEach(f=> {
      fileMetadatas(i) = new FileMetaData(f.getName,relDir+f.getName,FileUtils.sizeOf(f),new java.util.Date().toString)

      //println("filename : " + fileMetadatas(i) )
      i = i+1

    })
    println("size "+files.size())
    fileMetadatas.foreach(f=>println("filename: "+f.fileName+" directory path: "+f.directory+" file size: "+f.size)+" create date : "+f.createdDate)



    Ok(views.html.download(fileMetadatas))
  }
}
