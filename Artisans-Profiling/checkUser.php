<?php
	$con=mysqli_connect("localhost","id14527893_root","grB8e0[@rJ[\OOi=","id14527893_artisansprofiling");

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
// echo "success";
	echo json_encode(array("result"=>$result));

}
else{
	echo "Error";
}


?>