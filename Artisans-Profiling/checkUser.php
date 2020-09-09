<?php
	$con=mysqli_connect("localhost","root",""," id14527893_artisansprofiling");

	$phone = $_GET['phone'];
	$name = $_GET['name'];
	$result = array();
	$sql = "SELECT * FROM artisan WHERE `phone`=".$phone." and `name`=".$name;
	if($res = mysqli_query($con,$sql)){
	$row_count = mysqli_num_rows($res);
	array_push($result,array(
		'num' => $row_count
	));
	echo json_encode(array("result"=>$result));

}else{
	echo "Error";
}




?>