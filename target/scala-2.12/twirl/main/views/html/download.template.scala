
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object download extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Array[FileMetaData],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(files : Array[FileMetaData]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
       """),_display_(/*9.9*/for(file <- files) yield /*9.27*/{_display_(Seq[Any](format.raw/*9.28*/("""
           """),format.raw/*10.12*/("""<div>
           <span>"""),_display_(/*11.19*/file/*11.23*/.fileName),format.raw/*11.32*/("""</span> &nbsp;&nbsp;
           <span><a href=""""),_display_(/*12.28*/file/*12.32*/.directory),format.raw/*12.42*/("""">Download </a></span> &nbsp;&nbsp;
           <span>"""),_display_(/*13.19*/file/*13.23*/.createdDate),format.raw/*13.35*/("""</span> &nbsp;&nbsp;
           <span>"""),_display_(/*14.19*/file/*14.23*/.size),format.raw/*14.28*/("""</span> &nbsp;&nbsp;
           </div>
       """)))}),format.raw/*16.9*/("""
    """),format.raw/*17.5*/("""</body>
</html>"""))
      }
    }
  }

  def render(files:Array[FileMetaData]): play.twirl.api.HtmlFormat.Appendable = apply(files)

  def f:((Array[FileMetaData]) => play.twirl.api.HtmlFormat.Appendable) = (files) => apply(files)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jun 12 16:22:48 IST 2018
                  SOURCE: /home/rahul/Desktop/rahul_project/app/views/download.scala.html
                  HASH: 89484e83b48345b52fae4cc27d079596efac4851
                  MATRIX: 745->1|868->31|1028->166|1061->184|1099->185|1139->197|1190->221|1203->225|1233->234|1308->282|1321->286|1352->296|1433->350|1446->354|1479->366|1545->405|1558->409|1584->414|1661->461|1693->466
                  LINES: 21->1|26->2|33->9|33->9|33->9|34->10|35->11|35->11|35->11|36->12|36->12|36->12|37->13|37->13|37->13|38->14|38->14|38->14|40->16|41->17
                  -- GENERATED --
              */
          