// @SOURCE:/Users/premis/Documents/workspace/FalconPlay/conf/routes
// @HASH:3601b03765a9f0dd561b6db06f48a0eb41c31077
// @DATE:Fri Aug 09 02:13:54 EEST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:15
private[this] lazy val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:24
private[this] lazy val controllers_MessagerController_getMessagerPage2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messager"))))
        

// @LINE:26
private[this] lazy val controllers_MessagerController_postMessage3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messager/pushmessage"))))
        

// @LINE:28
private[this] lazy val controllers_MessagerController_registerSocket4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messager/handle"))))
        

// @LINE:30
private[this] lazy val controllers_MessagerController_deleteAllMessages5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messager/deleteall"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messager""","""controllers.MessagerController.getMessagerPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messager/pushmessage""","""controllers.MessagerController.postMessage()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messager/handle""","""controllers.MessagerController.registerSocket()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messager/deleteall""","""controllers.MessagerController.deleteAllMessages()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:15
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:24
case controllers_MessagerController_getMessagerPage2(params) => {
   call { 
        invokeHandler(controllers.MessagerController.getMessagerPage(), HandlerDef(this, "controllers.MessagerController", "getMessagerPage", Nil,"GET", """""", Routes.prefix + """messager"""))
   }
}
        

// @LINE:26
case controllers_MessagerController_postMessage3(params) => {
   call { 
        invokeHandler(controllers.MessagerController.postMessage(), HandlerDef(this, "controllers.MessagerController", "postMessage", Nil,"POST", """""", Routes.prefix + """messager/pushmessage"""))
   }
}
        

// @LINE:28
case controllers_MessagerController_registerSocket4(params) => {
   call { 
        invokeHandler(controllers.MessagerController.registerSocket(), HandlerDef(this, "controllers.MessagerController", "registerSocket", Nil,"GET", """""", Routes.prefix + """messager/handle"""))
   }
}
        

// @LINE:30
case controllers_MessagerController_deleteAllMessages5(params) => {
   call { 
        invokeHandler(controllers.MessagerController.deleteAllMessages(), HandlerDef(this, "controllers.MessagerController", "deleteAllMessages", Nil,"POST", """""", Routes.prefix + """messager/deleteall"""))
   }
}
        
}
    
}
        