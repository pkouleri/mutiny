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
            showGreeting(JSON.parse(mutinyPost.body).content);
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

function showGreeting(content) {
    $("#posts").append("<tr><td>" + content + "</td></tr>");
}

$(function () {
    connect();

    $("form").on('submit', function (e) {
        e.preventDefault();
    });

    $( "#send" ).click(function() { sendName(); });
});