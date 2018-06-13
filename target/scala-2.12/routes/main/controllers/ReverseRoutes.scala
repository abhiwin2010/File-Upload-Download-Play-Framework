// @GENERATOR:play-routes-compiler
// @SOURCE:/home/rahul/Desktop/rahul_project/conf/routes
// @DATE:Tue Jun 12 16:08:53 IST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def upload(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "upload")
    }
  
    // @LINE:12
    def download(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "download")
    }
  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
