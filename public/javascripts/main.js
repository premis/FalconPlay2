$(function() {
    var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket
    var sock = new WS("@routes.MessagerController.registerSocket().webSocketURL(request)")


    sock.onmessage = function(event) {
        $('.notification').append(event.data+"<br/>");
    }

    $('#messagesDeleteAllButton').click(function() {
        alert("delete all");
        $.ajax({
            type :  "POST",
            dataType: 'json',
            contentType : 'application/json',
            data: JSON.stringify({}),
            url  :  "@routes.MessagerController.deleteAllMessages()",
            success: function(data){
                console.log(data);
                alert(data.message);
            },
            error: function(){
                console.log("something went wrong with the ajax call");
            }
        });
    });

    $('#messageSendButton').click(function() {

        var value = $('#messageTextBox').val();
        var d = { 'key': value };

        //sock.send("dummyvalue");

        $.ajax({
            type :  "POST",
            dataType: 'json',
            contentType : 'application/json',
            data: JSON.stringify(d),
            url  :  "@routes.MessagerController.postMessage()",
            success: function(data){
                console.log(data);
                //alert(data.status+" - "+data.message);
            },
            error: function(){
                console.log("something went wrong with the ajax call");
            }
        });
    })

})