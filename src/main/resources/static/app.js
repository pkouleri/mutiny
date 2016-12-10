var stompClient = null;

function setConnected(connected) {
    if (connected) {
        $("#feed").show();
    } else {
        $("#feed").hide();
    }

    $("#posts").html("");
}

function connect() {
    var socket = new SockJS('/channel');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log("Connected: " + frame);
        stompClient.subscribe('/topic/posts', function(mutinyPost) {
            showGreeting(mutinyPost.body);
        })
    });
}

function disconnect() {
    if (stompClient!=null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/post", {}, JSON.stringify({'content': $("#content").val()}));
}

function sendPost() {
    var data = JSON.stringify($("#content").val());
    $.ajax({
        type: "POST",
        url: "/post",
        data: data,
        success: success,
        dataType: "json"
    });
}

function success() {
    console.log("success");
}

function showGreeting(content) {
    $("#posts").append("<tr><td>" + content + "</td></tr>");
}

$(function () {
    connect();

    $("#send").click(function () {
        sendPost();
    });
});