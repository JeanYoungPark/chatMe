var ws;

function wsOpen(){
    ws = new WebSocket("ws://" + location.host + "/chating/"+$("#roomNumber").val());
    wsEvt();
}

function wsEvt() {
    ws.onopen = function(data){
        //소켓이 열리면 초기화 세팅하기
    }

    ws.onmessage = function(data) {
        var msg = data.data;
        if(msg != null && msg.trim() != ''){

            var jsonData = JSON.parse(msg);

            if(jsonData.type == "getId"){

                var si = jsonData.sessionId != null ? jsonData.sessionId : "";
                if (si != "") $("#sessionId").val(si);

            }else if(jsonData.type == "message"){

                if(jsonData.sessionId == $("#sessionId").val()){
                    $("#chatting").append(`<p class='me'><span class="txt">${jsonData.msg}</span></p>`);
                }else {
                    $("#chatting").append(`<p class='others'><span class="nick">${jsonData.nickName}</span><span class="txt">${jsonData.msg}</span></p>`);
                }

            }else {
                console.warn("unknown type!");
            }

        }
    }

    document.addEventListener("keypress", function(e){
        if(e.keyCode == 13){ //enter press
            send();
        }
    });
}

function send() {
    var option = {
        type: "message",
        roomNumber:$("#roomNumber").val(),
        sessionId : $("#sessionId").val(),
        userId : $("#userId").val(),
        nickName : $("#nickName").val(),
        msg : $("#chat").val()
    }
    ws.send(JSON.stringify(option));
    $('#chat').val("");
}

wsOpen();