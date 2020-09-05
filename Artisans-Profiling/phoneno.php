<?php
		$con=new mysqli("localhost","root","","artisan-profiling");
//		$st_check=$con->prepare("SELECT * FROM artisan WHERE phone=?");
//		$st_check->bind_param("s", $_GET["phoneno"]);
//		$st_check->execute();
//		$rs=$st_check->get_result();
//		if($rs->num_rows==0)
//		{
		$st=$con->prepare("insert into artisan(phone) values(?)");
		$st->bind_param("s", $_GET["phoneno"]);
		$st->execute();
		//echo "data uploaded successfully!";
//		}
//		else
//			echo "User already exists!";


$sql = "SELECT * FROM artisan ORDER BY `id` DESC";
$res = mysqli_query($con,$sql);
$result = array();
 
if($row = mysqli_fetch_array($res)){
array_push($result,array(
'id'=>$row[0]
));
	//$id= $row[0];
}

//echo json_encode(array("result"=>$id));
echo json_encode(array("result"=>$result));
mysqli_close($con);

		?>
