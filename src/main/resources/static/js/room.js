$(document).ready(function(){
    $('.toggleBtn').on('click',function(){
        $('.popup').toggle();
    });

    $('.close').on('click',function(){
        $('.popup').hide();
    });
});