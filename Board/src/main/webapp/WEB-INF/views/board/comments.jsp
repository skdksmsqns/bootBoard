<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript" >

var no = '${vo.no}'; //게시글 번호
 
$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
    var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
    commentInsert(insertData); //Insert 함수호출(아래)
});
 
 
//댓글 목록 
function commentList(){
    $.ajax({
        url : '/comment/list',
        type : 'get',
        data : {'no':no},
        success : function(data){
            var a =''; 
            $.each(data, function(key, value){ 
                a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                a += '<div class="commentInfo'+value.qnaNo+'">'+'댓글번호 : '+value.qnaNo+' / 작성자 : '+value.qnaWriter;
                a += '<a onclick="commentUpdate('+value.qnaNo+',\''+value.qnaContent+'\');"> 수정 </a>';
                a += '<a onclick="commentDelete('+value.qnaNo+');"> 삭제 </a> </div>';
                a += '<div class="commentContent'+value.qnaNo+'"> <p> 내용 : '+value.qnaContent +'</p>';
                a += '</div></div>';
            });
            
            $(".commentList").html(a);
        }
    });
}
 
//댓글 등록
function commentInsert(insertData){
    $.ajax({
        url : '/comment/write',
        type : 'post',
        data : insertData,
        success : function(data){
            if(data == 1) {
                commentList(); //댓글 작성 후 댓글 목록 reload
                $('[name=content]').val('');
            }
        }
    });
}
 
//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function commentUpdate(qnaNo, qnaContent){
    var a ='';
    
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+qnaNo+'" value="'+qnaContent+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+qnaNo+');">수정</button> </span>';
    a += '</div>';
    
    $('.commentContent'+qnaNo).html(a);
    
}
 
//댓글 수정
function commentUpdateProc(qnaNo){
    var updateContent = $('[name=content_'+qnaNo+']').val();
    
    $.ajax({
        url : '/comment/update',
        type : 'post',
        data : {'qnaContent' : updateContent, 'qnaNo' : qnaNo},
        success : function(data){
            if(data == 1) commentList(no); //댓글 수정후 목록 출력 
        }
    });
}
 
//댓글 삭제 
function commentDelete(qnaNo){
    $.ajax({
        url : '/comment/delete/'+qnaNo,
        type : 'post',
        success : function(data){
            if(data == 1) commentList(
); //댓글 삭제후 목록 출력 
        }
    });
}
 
 
 
 
$(document).ready(function(){
    commentList(); //페이지 로딩시 댓글 목록 출력 
});
 
  
</script>
