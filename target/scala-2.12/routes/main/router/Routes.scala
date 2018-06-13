// @GENERATOR:play-routes-compiler
// @SOURCE:/home/rahul/Desktop/rahul_project/conf/routes
// @DATE:Tue Jun 12 16:08:53 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  HomeController_0: controllers.HomeController,
  // @LINE:10
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    HomeController_0: controllers.HomeController,
    // @LINE:10
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """upload""", """controllers.HomeController.upload"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """download""", """controllers.HomeController.download"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_upload1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("upload")))
  )
  private[this] lazy val controllers_HomeController_upload1_invoker = createInvoker(
    HomeController_0.upload,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "upload",
      Nil,
      "POST",
      this.prefix + """upload""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Assets_versioned2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned2_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_download3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("download")))
  )
  private[this] lazy val controllers_HomeController_download3_invoker = createInvoker(
    HomeController_0.download,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "download",
      Nil,
      "GET",
      this.prefix + """download""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:7
    case controllers_HomeController_upload1_route(params@_) =>
      call { 
        controllers_HomeController_upload1_invoker.call(HomeController_0.upload)
      }
  
    // @LINE:10
    case controllers_Assets_versioned2_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned2_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:12
    case controllers_HomeController_download3_route(params@_) =>
      call { 
        controllers_HomeController_download3_invoker.call(HomeController_0.download)
      }
  }
}
