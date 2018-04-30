
$(function (){

var $data = $('#data');
var $firstName = $('#firstName');
var $secondName = $('#secondName');
var $accountNumber = $('#accountNumber');

var $editaccountNumber = $('#editaccountNumber');
var $editsecondName = $('#editsecondName');
var $editfirstName = $('#editfirstName');
var $editID = $('#editID');



$.ajax({
	type:'GET',
	url: '/AccountProject/api/Account/json',
	success: function(data){
		console.log('success', data);
		$.each(data, function(i, account){
		$data.append('<li> accountid: ' + account.id + '  firstname: ' + account.firstName + '  secondname: ' + account.secondName + '  accountnumber: ' + account.accountNumber + '</li> <button data-id= "' + account.id + '" type="button" id="deletebtn">Delete</button> <button data-id= "' + account.id + '" type="button" id="editbtn">Edit</button>');
		
	});	
	},
	error: function(){
	alert('error fetching data');
	}
});

$('#add-account').on('click', function(){

var order = {
firstName: $firstName.val(),
secondName: $secondName.val(),
accountNumber: $accountNumber.val(),

};

$.ajax({
	type: 'POST',
	url: '/AccountProject/api/Account/json',
	data: JSON.stringify(order),
	success: function(newAccount){
	
alert('account added');
},
	
	
	
error: function(){
alert('account added');
}

});


});


$data.delegate('#deletebtn','click', function(){

var $li = $(this).closest('li');

$.ajax({
type: 'DELETE',
url:  '/AccountProject/api/Account/json/' + $(this).attr('data-id'),
success: function(){
$li.remove();
alert('account deleted');
location.reload();
}



});
});

$data.delegate('#editbtn','click', function(){

var change = {
id: $editID.val(),
firstName: $editfirstName.val(),
secondName: $editsecondName.val(),
accountNumber: $editaccountNumber.val(),



};

$.ajax({
	type: 'PUT',
	url: '/AccountProject/api/Account/json/' + $(this).attr('data-id'),
	data: JSON.stringify(change),
	success: function(newAccount){
	
alert('account updated');
location.reload();
},
	
	
	
error: function(){
alert('if not added please try again');
}

});


});



});