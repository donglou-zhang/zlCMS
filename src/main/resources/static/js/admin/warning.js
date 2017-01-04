/*created by WunGCQ 2014/12/16 */
/*use this funtion to create warning window instead of alert window!*/
/*if is_closr_button_remain is true it will have a button for closing this window */
/*if you wabt to change the color theme of the window just give the color 's':success , 'f':failed ,'#000000' black  but rgb,colorname and rgba are not supported */
/*you can give the function a button and the function when click this function!*/ 
/*please import jquery~~*/

function warn(title,content,color,is_close_button_remain,button1_text,button1_function){
    if(document.getElementById('warning')!=null){
        remove_warning(function(){ warn(title,content,color,is_close_button_remain,button1_text,button1_function);
        });
    }

    else {

        var button2text = judge_button2_text(button1_text, ["返回", "关闭窗口", "我知道了", "取消"]);//the words of the close button
        var str = [
            '<div id="warning">',
            '<div id="warning-window">',
            '<div id="warning-title">',
            '</div>',
            '<div id="warning-close" onclick="remove_warning()">×</div>',
            '<div id="warning-wrap"><div id=\"warning-content\">',
            '</div>',
            '<div id="warning-button-wrap">',
            '</div>',
            '</div>',
            '</div>'
        ];
        $("body").append(str.join(''));
        $("#warning-title").text(title);
        $("#warning-content").text(content);
        //button1
        if (button1_text != null || typeof(button1_text) != "undefined") {
            $("#warning-button-wrap").append('<button class="btn"></button>');
            $("#warning button:first-child").text(button1_text);
            if (button1_function != null && typeof(button1_function) != "undefined") {
                $("#warning button:first-child").click(function () {
                    var fun1 = button1_function;
                    fun1();
                    remove_warning();
                });
            }
        }
        if (is_close_button_remain) {
            $("#warning-button-wrap").append('<button class="btn"></button>');

            $("#warning button:last-child").text(button2text);
            $("#warning button:last-child").click(function () {
                remove_warning()
            });
        }

        document.getElementById('warning').addEventListener('click', function (event) {
           if(event.target.id=='warning'){
               remove_warning();
           }
        }, false);
//    修改样式
        if (color != null || color != "") {
            if (color == "f") {
                color = "#a00";
            }
            else if (color == "s") {
                color = "#264D7B";
            }
            $("#warning-title").css({"background-color": color});
            $("#warning-close").css({"background-color": color});
            $("#warning-content").css({"color": color});
            $("#warning-wrap").css({"border-color": color});
            $("#warning button").css({"background-color": color});

            var brighter_color = get_brighter_color(color);
            $("#warning button").hover(function () {
                $(this).css({"background-color": brighter_color});
            });
            $("#warning button").mouseleave(function () {
                $(this).css({"background-color": color});
            });
        }
        var windowHeight = document.documentElement.clientHeight;
        var mt = (Math.floor((windowHeight - 480) / 2)).toString() + "px";
        //$("#warning-window").css();

        $('#warning').animate({left: 0, opacity: 1}, 200);
        $('#warning-window').delay(200).animate({marginTop: mt, opacity: 1}, 300);
        return true;
    }

}


function get_brighter_color(color){
    color = color.toLowerCase();
    var res = "#";
    for(var i =1;i<color.length;i++){
        if(color[i]=="f"){
            res+="f";
        }
        else if(color[i]=="e"){
            res+="f";
        }
        else if(color[i]=="d"){
            res+="f";
        }
        else if(color[i]=="c"){
            res+="d";
        }
        else if(color[i]=="b"){
            res+="c";
        }
        else if(color[i]=="a"){
            res+="b";
        }
        else if(color[i]=="9") {
            res += "a";
        }
        else if(color[i]=="8") {
            res += "a";
        }
        else {
            res += (parseInt(color[i])+2).toString();
        }
    }
    return res;
}

function judge_button2_text(button1,string_arr){
    for(var i =0;i<string_arr.length;i++){
        if(string_arr.indexOf(button1)==-1){
            return string_arr[i];
        }
    }
}
function remove_warning(Callback){
    $('#warning-window').animate({marginTop:0,opacity:0},300);

    setTimeout(function(){$('#warning').animate({opacity:0},200);},300);

    setTimeout(function(){
            $('#warning').remove();
    },500);
    if(Callback!=null){
        setTimeout(function(){
            Callback();
            return true;
        },510);
    }
    return true;

}