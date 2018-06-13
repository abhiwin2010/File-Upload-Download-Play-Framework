// @GENERATOR:play-routes-compiler
// @SOURCE:/home/rahul/Desktop/rahul_project/conf/routes
// @DATE:Tue Jun 12 16:08:53 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
