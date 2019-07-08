var replyService = (function () {

    const  host = "/replies/"

    var idx=0;
    function countUp() {
        return ++idx;
    }

    function addReply(obj, callback) {
    $.ajax({
        type:"post",
        url:host+"new",
        data:JSON.stringify(obj),
        contentType:"application/json",
        success:function () {
            if (callback){
                callback(

                );
            }
        }
    })
    }
    function modifyReply(obj, callback) {
        $.ajax({
            type:"put",
            url:host+"modify",
            data:JSON.stringify(obj),
            contentType:"application/json",
            success:function () {
                if (callback){
                    callback(

                    );
                }
            }
        })
        }
    function getList(bno,callback) {
        $.getJSON(  host+bno+"/1.json",
            null,
             function(arr) {
            if (callback) {
                callback(arr

                );
            }

        })
    }
    function getReply(rno,callback) {
        $.getJSON(  host+rno+".json",
            null,
             function(arr) {
            if (callback) {
                callback(arr

                );
            }

        })
    }


    function removeReply(rno,callback){
    	$.ajax({
    		type:"delete",
    		url:host+rno,
    		success:function () {
    			if (callback){
    				callback(
    						
    				);
    			}
    		}
    	})
   
    }
    return {
    	modifyReply:modifyReply,
    	removeReply:removeReply,
    	getReply:getReply,
        countUp:countUp,
        addReply:addReply,
        getList:getList
    }
    
})(); // 즉시 실행하는 함수

