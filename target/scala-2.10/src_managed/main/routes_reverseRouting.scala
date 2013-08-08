// @SOURCE:/Users/premis/Documents/workspace/FalconPlay/conf/routes
// @HASH:b0ae279b51821110937c462f9c8f0be7ca0e4d85
// @DATE:Wed Aug 07 19:45:40 EEST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:24
// @LINE:15
// @LINE:6
package controllers {

// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:24
class ReverseMessager {
    

// @LINE:26
def postMessage(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "messager/pushmessage")
}
                                                

// @LINE:30
def deleteAllMessages(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "messager/deleteall")
}
                                                

// @LINE:24
def getMessagerPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "messager")
}
                                                

// @LINE:28
def registerSocket(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "messager/handle")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:24
// @LINE:15
// @LINE:6
package controllers.javascript {

// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:24
class ReverseMessager {
    

// @LINE:26
def postMessage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessagerController.postMessage",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "messager/pushmessage"})
      }
   """
)
                        

// @LINE:30
def deleteAllMessages : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessagerController.deleteAllMessages",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "messager/deleteall"})
      }
   """
)
                        

// @LINE:24
def getMessagerPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessagerController.getMessagerPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messager"})
      }
   """
)
                        

// @LINE:28
def registerSocket : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MessagerController.registerSocket",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messager/handle"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:24
// @LINE:15
// @LINE:6
package controllers.ref {

// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:24
class ReverseMessager {
    

// @LINE:26
def postMessage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessagerController.postMessage(), HandlerDef(this, "controllers.MessagerController", "postMessage", Seq(), "POST", """""", _prefix + """messager/pushmessage""")
)
                      

// @LINE:30
def deleteAllMessages(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessagerController.deleteAllMessages(), HandlerDef(this, "controllers.MessagerController", "deleteAllMessages", Seq(), "POST", """""", _prefix + """messager/deleteall""")
)
                      

// @LINE:24
def getMessagerPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessagerController.getMessagerPage(), HandlerDef(this, "controllers.MessagerController", "getMessagerPage", Seq(), "GET", """""", _prefix + """messager""")
)
                      

// @LINE:28
def registerSocket(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MessagerController.registerSocket(), HandlerDef(this, "controllers.MessagerController", "registerSocket", Seq(), "GET", """""", _prefix + """messager/handle""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:15
class ReverseAssets {
    

// @LINE:15
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      