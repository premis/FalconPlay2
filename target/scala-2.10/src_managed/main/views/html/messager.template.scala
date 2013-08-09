
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
            var sock = new WS('"""),_display_(Seq[Any](/*46.33*/routes/*46.39*/.Messager.registerSocket().webSocketURL(request))),format.raw/*46.87*/("""');


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
                """),format.raw/*91.17*/("""}"""),format.raw/*91.18*/(""")
            """),format.raw/*92.13*/("""}"""),format.raw/*92.14*/(""")
        """),format.raw/*93.9*/("""}"""),format.raw/*93.10*/(""")


    </script>

""")))})))}
    }
    
    def render(messages:List[Message]): play.api.templates.Html = apply(messages)
    
    def f:((List[Message]) => play.api.templates.Html) = (messages) => apply(messages)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Aug 09 03:32:51 EEST 2013
                    SOURCE: /Users/premis/Documents/workspace/FalconPlay/app/views/messager.scala.html
                    HASH: c04736e099f5358623c9db68a2919ccc5adb24a6
                    MATRIX: 752->1|854->26|891->29|920->50|958->51|1282->339|1322->363|1362->365|1480->447|1496->454|1527->463|1615->515|1631->522|1664->533|1769->606|2212->1021|2241->1022|2381->1126|2396->1132|2466->1180|2545->1231|2574->1232|2678->1308|2707->1309|2796->1370|2825->1371|2914->1432|2943->1433|3141->1603|3170->1604|3199->1605|3268->1638|3283->1644|3334->1673|3408->1719|3437->1720|3566->1821|3595->1822|3662->1861|3691->1862|3816->1959|3845->1960|3890->1977|3919->1978|3962->1993|3991->1994|4076->2051|4105->2052|4215->2134|4244->2135|4286->2149|4315->2150|4413->2220|4442->2221|4682->2425|4697->2431|4742->2454|4816->2500|4845->2501|4994->2622|5023->2623|5090->2662|5119->2663|5244->2760|5273->2761|5318->2778|5347->2779|5389->2793|5418->2794|5455->2804|5484->2805
                    LINES: 27->1|30->1|32->3|32->3|32->3|45->16|45->16|45->16|47->18|47->18|47->18|48->19|48->19|48->19|51->22|73->44|73->44|75->46|75->46|75->46|78->49|78->49|80->51|80->51|82->53|82->53|84->55|84->55|88->59|88->59|88->59|89->60|89->60|89->60|90->61|90->61|93->64|93->64|94->65|94->65|96->67|96->67|97->68|97->68|98->69|98->69|100->71|100->71|103->74|103->74|103->74|103->74|107->78|107->78|112->83|112->83|112->83|113->84|113->84|116->87|116->87|117->88|117->88|119->90|119->90|120->91|120->91|121->92|121->92|122->93|122->93
                    -- GENERATED --
                */
            