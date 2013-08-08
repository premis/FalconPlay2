
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


    <script type="text/javascript" charset="utf-8">


        $(function() """),format.raw/*44.22*/("""{"""),format.raw/*44.23*/("""
            var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket
            var sock = new WS(""""),_display_(Seq[Any](/*46.33*/routes/*46.39*/.Messager.registerSocket().webSocketURL(request))),format.raw/*46.87*/("""")


            sock.onmessage = function(event) """),format.raw/*49.46*/("""{"""),format.raw/*49.47*/("""
                $('.notification').append(event.data+"<br/>");
            """),format.raw/*51.13*/("""}"""),format.raw/*51.14*/("""

            $('#messagesDeleteAllButton').click(function() """),format.raw/*53.60*/("""{"""),format.raw/*53.61*/("""
                alert("delete all");
                $.ajax("""),format.raw/*55.24*/("""{"""),format.raw/*55.25*/("""
                    type :  "POST",
                    dataType: 'json',
                    contentType : 'application/json',
                    data: JSON.stringify("""),format.raw/*59.42*/("""{"""),format.raw/*59.43*/("""}"""),format.raw/*59.44*/("""),
                    url  :  """"),_display_(Seq[Any](/*60.31*/routes/*60.37*/.Messager.deleteAllMessages())),format.raw/*60.66*/("""",
                    success: function(data)"""),format.raw/*61.44*/("""{"""),format.raw/*61.45*/("""
                        console.log(data);
                        alert(data.message);
                    """),format.raw/*64.21*/("""}"""),format.raw/*64.22*/(""",
                    error: function()"""),format.raw/*65.38*/("""{"""),format.raw/*65.39*/("""
                        console.log("something went wrong with the ajax call");
                    """),format.raw/*67.21*/("""}"""),format.raw/*67.22*/("""
                """),format.raw/*68.17*/("""}"""),format.raw/*68.18*/(""");
            """),format.raw/*69.13*/("""}"""),format.raw/*69.14*/(""");

            $('#messageSendButton').click(function() """),format.raw/*71.54*/("""{"""),format.raw/*71.55*/("""

                var value = $('#messageTextBox').val();
                var d = """),format.raw/*74.25*/("""{"""),format.raw/*74.26*/(""" 'key': value """),format.raw/*74.40*/("""}"""),format.raw/*74.41*/(""";

                //sock.send("dummyvalue");

                $.ajax("""),format.raw/*78.24*/("""{"""),format.raw/*78.25*/("""
                    type :  "POST",
                    dataType: 'json',
                    contentType : 'application/json',
                    data: JSON.stringify(d),
                    url  :  """"),_display_(Seq[Any](/*83.31*/routes/*83.37*/.Messager.postMessage())),format.raw/*83.60*/("""",
                    success: function(data)"""),format.raw/*84.44*/("""{"""),format.raw/*84.45*/("""
                        console.log(data);
                        //alert(data.status+" - "+data.message);
                    """),format.raw/*87.21*/("""}"""),format.raw/*87.22*/(""",
                    error: function()"""),format.raw/*88.38*/("""{"""),format.raw/*88.39*/("""
                        console.log("something went wrong with the ajax call");
                    """),format.raw/*90.21*/("""}"""),format.raw/*90.22*/("""
                """),format.raw/*91.17*/("""}"""),format.raw/*91.18*/(""");
            """),format.raw/*92.13*/("""}"""),format.raw/*92.14*/(""")

        """),format.raw/*94.9*/("""}"""),format.raw/*94.10*/(""")


    </script>

""")))})))}
    }
    
    def render(messages:List[Message]): play.api.templates.Html = apply(messages)
    
    def f:((List[Message]) => play.api.templates.Html) = (messages) => apply(messages)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Aug 07 20:03:40 EEST 2013
                    SOURCE: /Users/premis/Documents/workspace/FalconPlay/app/views/messager.scala.html
                    HASH: 0f15ba813f684cb78589c22d7ef80c97bd586fb6
                    MATRIX: 752->1|854->26|891->29|920->50|958->51|1282->339|1322->363|1362->365|1480->447|1496->454|1527->463|1615->515|1631->522|1664->533|1769->606|2212->1021|2241->1022|2381->1126|2396->1132|2466->1180|2544->1230|2573->1231|2677->1307|2706->1308|2795->1369|2824->1370|2913->1431|2942->1432|3140->1602|3169->1603|3198->1604|3267->1637|3282->1643|3333->1672|3407->1718|3436->1719|3573->1828|3602->1829|3669->1868|3698->1869|3827->1970|3856->1971|3901->1988|3930->1989|3973->2004|4002->2005|4087->2062|4116->2063|4226->2145|4255->2146|4297->2160|4326->2161|4424->2231|4453->2232|4693->2436|4708->2442|4753->2465|4827->2511|4856->2512|5013->2641|5042->2642|5109->2681|5138->2682|5267->2783|5296->2784|5341->2801|5370->2802|5413->2817|5442->2818|5480->2829|5509->2830
                    LINES: 27->1|30->1|32->3|32->3|32->3|45->16|45->16|45->16|47->18|47->18|47->18|48->19|48->19|48->19|51->22|73->44|73->44|75->46|75->46|75->46|78->49|78->49|80->51|80->51|82->53|82->53|84->55|84->55|88->59|88->59|88->59|89->60|89->60|89->60|90->61|90->61|93->64|93->64|94->65|94->65|96->67|96->67|97->68|97->68|98->69|98->69|100->71|100->71|103->74|103->74|103->74|103->74|107->78|107->78|112->83|112->83|112->83|113->84|113->84|116->87|116->87|117->88|117->88|119->90|119->90|120->91|120->91|121->92|121->92|123->94|123->94
                    -- GENERATED --
                */
            