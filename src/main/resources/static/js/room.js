$(document).ready(function(){
    $('.toggleBtn').on('click',function(){
        $('.popup').toggle();
    });

    $('.close').on('click',function(){
        $('.popup').hide();
    });

    $('#createRoom').on('click',function(){
        var msg = { roomName : $('#roomName').val() };

        $.ajax({
            url:'/create/room',
            data:JSON.stringify(msg),
            type:'post',
            contentType:'application/json; charset=utf-8'
        }).done(function(res){
            createChattingRoom(res);
        }).fail(function(err){
            console.log(err);
        });

        $('.roomName').val('');
        $('.popup').toggle();
    });

    getRoom();
});

function getRoom(){
    $.ajax({
        url:'/get/room',
        type:'post',
        contentType:'application/json; charset=utf-8'
    }).done(function(res){
        createChattingRoom(res);
    }).fail(function(err){
        console.log(err);
    });
}

function createChattingRoom(res){
    if(res != null){
        var tag = "";

        if(res.length > 1) {
            $.each(res,function(idx, data){
                var roomName = data.roomName;
                var roomNumber = data.id;
                tag += `<tr><td>${roomName}</td><td><button type="button" onclick="goRoom(${roomNumber})">참여</button></td></td></tr>`;
            });

            $('#roomList tbody').empty().append(tag);
        }else {
            tag += `<tr><td>${res.roomName}</td><td><button type="button" onclick="goRoom(${res.roomNumber})">참여</button></td></td></tr>`;

            $('#roomList tbody').prepend(tag);
        }

    }
}

function goRoom(number, name){
    location.href = `/move/room?roomNumber=${number}`;
}