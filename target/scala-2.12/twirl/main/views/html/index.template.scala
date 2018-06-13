
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[controllers.FormData],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[controllers.FormData])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
  """),_display_(/*4.4*/helper/*4.10*/.form(action = routes.HomeController.upload, 'enctype -> "multipart/form-data")/*4.89*/ {_display_(Seq[Any](format.raw/*4.91*/("""
    """),_display_(/*5.6*/helper/*5.12*/.inputFile(form("name"))),format.raw/*5.36*/("""
    """),_display_(/*6.6*/helper/*6.12*/.CSRF.formField),format.raw/*6.27*/("""
    """),format.raw/*7.5*/("""<input type="submit" id="upload" value="upload file"/>
  """)))}),format.raw/*8.4*/("""
""")))}),format.raw/*9.2*/("""
"""))
      }
    }
  }

  def render(form:Form[controllers.FormData],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(form)(request)

  def f:((Form[controllers.FormData]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (form) => (request) => apply(form)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Jun 11 16:14:27 IST 2018
                  SOURCE: /home/rahul/Desktop/rahul_project/app/views/index.scala.html
                  HASH: 7e7dda518139d1f967d8e3b748d572557a8b7e45
                  MATRIX: 771->1|940->77|967->79|998->102|1037->104|1066->108|1080->114|1167->193|1206->195|1237->201|1251->207|1295->231|1326->237|1340->243|1375->258|1406->263|1493->321|1524->323
                  LINES: 21->1|26->2|27->3|27->3|27->3|28->4|28->4|28->4|28->4|29->5|29->5|29->5|30->6|30->6|30->6|31->7|32->8|33->9
                  -- GENERATED --
              */
          