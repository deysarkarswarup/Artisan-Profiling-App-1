<?php	
$con=new mysqli("localhost","root","","artisan-profiling");
$sql = "SELECT * FROM artform";
$res = mysqli_query($con,$sql);
$result = array();
while($row = mysqli_fetch_array($res)){
array_push($result,array(
//'itel'=>$row[2],
//'iname'=>$row[1],
'artFormName'=>$row[1]

));
}
 
echo json_encode(array("result"=>$result));
mysqli_close($con);

//		$phno=$_GET["phoneno"];
//		$ar = $_GET["artform"];
//		$st=$con->prepare("UPDATE `artisan` set `artform`=? where `phoneno`=?");
//		$st->bind_param("ss", $ar, $phno);
//		$st->execute();
//		echo "data uploaded successfully!";
		?>
