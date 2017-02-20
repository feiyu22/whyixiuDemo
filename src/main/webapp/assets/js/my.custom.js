function returnProccss(data){
	if(data.return_code=="301"){
		alert(data.return_msg);
		return true;
	}else if(data.return_code=="302"){
		alert(data.return_msg);
		return true;
	}else if(data.return_code=="303"){
		alert(data.return_msg);
		return true;
	}else if(data.return_code=="304"){
		alert(data.return_msg);
		return true;
	}
}

$(function(){
	
//	checkbox多选框样式
	$('.for_check, .checked_all').iCheck({
		checkboxClass : "icheckbox_square-green",
		radioClass : "iradio_square-green",
	});
//	全选多选框
	$('.checked_all').on('ifChanged', function(){
		var $this = $(this);
		var curr_checked = $this.find('input:checkbox')[0].checked;
		$('input[name='+$this.attr('checked-for')+']:checkbox').parent().each(function(){
			if(curr_checked){
				$(this).iCheck('check');
			}else{
				$(this).iCheck('uncheck');
			}
		});
	});
	
//	刷新样式
	$('.refresh').click(function(){
		layer.load();
	});
	
//	改变每页显示的数据量
	$('#page select').change(function(){
		var $this = $(this);
		var hideForm = $('#hide_form');
		var action = hideForm.attr('action');
		if(action==undefined||action==""){
			hideForm.attr('action', $('#search_form').attr('action'));
		}
		hideForm.find('.numPerPage').val($this.val());
		hideForm.submit();
		layer.load();
	});
//	直接跳转页面
	$('#page .jump').click(function(){
		var $this = $(this);
		var page = $this.prev();
		if(page.val()!=""&&/^[0-9]*$/.test(page.val())&&parseInt(page.val())>0){
			var hideForm = $('#hide_form');
			var action = hideForm.attr('action');
			if(action==undefined||action==""){
				hideForm.attr('action', $('#search_form').attr('action'));
			}
			hideForm.find('.pageNum').val(page.val());
			hideForm.submit();
			layer.load();
		}else{
			layer.tips('<i class="fa fa-warning"></i> 请输在总页数范围中的正整数', this);
		}
	});
//	跳回到首页
	$('#page .first').click(function(){
		var hideForm = $('#hide_form');
		var action = hideForm.attr('action');
		if(action==undefined||action==""){
			hideForm.attr('action', $('#search_form').attr('action'));
		}
		hideForm.find('.pageNum').val(1);
		hideForm.submit();
		layer.load();
	});
//	上一页
	$('#page .prev').click(function(){
		var hideForm = $('#hide_form');
		var action = hideForm.attr('action');
		if(action==undefined||action==""){
			hideForm.attr('action', $('#search_form').attr('action'));
		}
		hideForm.find('.pageNum').val(parseInt($('#page .pageNum').text())-1);
		hideForm.submit();
		layer.load();
	});
//	下一页
	$('#page .next').click(function(){
		var hideForm = $('#hide_form');
		var action = hideForm.attr('action');
		if(action==undefined||action==""){
			hideForm.attr('action', $('#search_form').attr('action'));
		}
		hideForm.find('.pageNum').val(parseInt($('#page .pageNum').text())+1);
		hideForm.submit();
		layer.load();
	});
//	尾页
	$('#page .last').click(function(){
		var hideForm = $('#hide_form');
		var action = hideForm.attr('action');
		if(action==undefined||action==""){
			hideForm.attr('action', $('#search_form').attr('action'));
		}
		hideForm.find('.pageNum').val($('#page input[name=totalPageCount]').val());
		hideForm.submit();
		layer.load();
	});
//	添加
	$('.tab_add').click(function(){
		layer.load();
	});
//	修改
	$('.tab_edit').click(function(e){
		var $this = $(this);
		var href = $this.attr('href');
		var checkName = href.substring(href.indexOf('{')+1, href.indexOf('}'));
		var checkboxs = $('input[name='+checkName+']:checked');
		if(checkboxs.length!=1){
			e.preventDefault();
			layer.tips('<i class="fa fa-warning"></i> 请选择一条数据进行操作', this);
		}else{
			var id = checkboxs.eq(0).val();
			$this.attr('href', href.substring(0, href.indexOf('{'))+id+href.substring(href.indexOf('}')+1, href.length));
			layer.load();
		}
	});
//	删除
	$('.tab_del').click(function(e){
		e.preventDefault();
		var $this = $(this);
		var href = $this.attr('href');
		var checkName = href.substring(href.indexOf('{')+1, href.indexOf('}'));
		var checkboxs = $('input[name='+checkName+']:checked');
		if(checkboxs.length>=1){
			var checkids = "";
			$.each(checkboxs, function(index, value){
				if(index==0){
					checkids+=value.value;
				}else{
					checkids+=","+value.value;
				}
			});
			parent.layer.confirm('这些数据一旦删除，便无法恢复！', {
				title: "<i class=\"fa fa-warning\"></i> 您确定要删除这些数据么？", 
				btn : [ '确定', '取消' ], // 按钮
				skin: 'layui-layer-molv'
			}, function() {
				window.location = href.substring(0, href.indexOf('{'))+checkids+href.substring(href.indexOf('}')+1, href.length);
				parent.layer.msg('删除成功', {
					icon : 1,
					skin: 'text-center'
				});
			}, function() {
//				parent.layer.msg('已取消', {
//					shift : 6
//				});
				parent.layer.close();
			});
		}else{
			layer.tips('<i class="fa fa-warning"></i> 请最少选择一条数据', this);
		}
	});
	
});