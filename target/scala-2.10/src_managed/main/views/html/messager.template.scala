
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
import java.util._
/**/
object messager extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Message],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(messages: List[Message]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""

"""),_display_(Seq[Any](/*3.2*/main("messages list")/*3.23*/{_display_(Seq[Any](format.raw/*3.24*/("""



    <div class="messages">

        <div class="messagesHeader">Redis persisted messages: </div>

        <div class="messageEntry" style="font-weight: bold">
            <div class="messageKey"> key </div>
            <div class="messageValue"> value </div>
        </div>

        """),_display_(Seq[Any](/*16.10*/for(message <- messages) yield /*16.34*/ {_display_(Seq[Any](format.raw/*16.36*/("""
            <div class="messageEntry">
                <div class="messageKey"> """),_display_(Seq[Any](/*18.43*/message/*18.50*/.getKey())),format.raw/*18.59*/(""" </div>
                <div class="messageValue"> """),_display_(Seq[Any](/*19.45*/message/*19.52*/.getValue())),format.raw/*19.63*/(""" </div>
            </div>
            <br style="clear:both"/>
        """)))})),format.raw/*22.10*/("""

    </div>

    <div class="notification">

    </div>

    <div class="operations">

        <input id="messageTextBox" type="text" style="width: 400px;" value="dummy message"> </input>

        <button id="messageSendButton">Send Message</button>

        <button id="messagesDeleteAllButton">Delete All Messages</button>

    </div>

""")))})))}
    }
    
    def render(messages:List[Message]): play.api.templates.Html = apply(messages)
    
    def f:((List[Message]) => play.api.templates.Html) = (messages) => apply(messages)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Aug 09 02:14:00 EEST 2013
                    SOURCE: /Users/premis/Documents/workspace/FalconPlay/app/views/messager.scala.html
                    HASH: 175d7900026d42f0f274c2992caeaf9aef784b99
                    MATRIX: 752->1|854->26|891->29|920->50|958->51|1282->339|1322->363|1362->365|1480->447|1496->454|1527->463|1615->515|1631->522|1664->533|1769->606
                    LINES: 27->1|30->1|32->3|32->3|32->3|45->16|45->16|45->16|47->18|47->18|47->18|48->19|48->19|48->19|51->22
                    -- GENERATED --
                */
            