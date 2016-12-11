var stompClient = null;
//
//function setConnected(connected) {
//    if (connected) {
//        $("#feed").show();
//    } else {
//        $("#feed").hide();
//    }
//
//    $("#posts").html("");
//}

function connect() {
    //var socket = new SockJS('/channel');
    //stompClient = Stomp.over(socket);
    //stompClient.connect({}, function(frame) {
    //    //setConnected(true);
    //    console.log("Connected: " + frame);
    //    stompClient.subscribe('/topic/posts', function(mutinyPost) {
    //        showGreeting(mutinyPost.body);
    //    })
    //});
}

$(function () {
    connect();
});