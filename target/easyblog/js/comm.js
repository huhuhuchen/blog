
//全选
$('#selectAll').on('click',function(){
	var that = this;
	$('.eid').attr('checked',that.checked);
})

//安全退出
function logout(){
	//提示确认框
	layer.confirm('是否确定退出?',{
		btn:['确认','取消'],   //配置按钮
		icon:3				 //配置图标
	},function(){
		location.href='login.html';
	});
}