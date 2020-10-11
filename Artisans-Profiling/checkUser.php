<?php
	$con=mysqli_connect("localhost","root","","artisan-profiling");

	$phone = $_GET['phone'];
	$name = $_GET['name'];
	$result = array();
	$sql = "SELECT * FROM artisan WHERE `phone`='".$phone."' AND `name`='".$name."'";
// echo $sql;	
	if($res = mysqli_query($con,$sql)){
	    
	$row_count = mysqli_num_rows($res);
// 	echo $row_count;
$row = mysqli_fetch_array($res);
	array_push($result,array(
		'num' => strval($row_count),
		'id' => $row[0]
	));

	echo json_encode(array("result"=>$result));

}
else{
	echo "Error";
}


?>