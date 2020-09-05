<?php
		$con=mysqli_connect("localhost","root","","artisan-profiling");
	//	$con1= new mysqli("localhost","root","","artisan-profiling");

//$con=mysqli_connect("localhost","id14527893_root","grB8e0[@rJ[\OOi=","id14527893_artisansprofiling");
//$con1=new mysqli("localhost","id14527893_root","grB8e0[@rJ[\OOi=","id14527893_artisansprofiling");
		
		$ex = $_GET['exp'];
		$org = $_GET['orgmember'];
		$id=$_GET['id'];
		//$artform=$_GET['artform'];
	//	echo "string";
	//	echo $id ;
	//	echo $org ;
	//	echo $ex;
		//echo $artform;
	//	$st=$con1->prepare("UPDATE `artisan` SET `experience`=? WHERE `id`=?");
	//	$st->bind_param("ss", $ex, $id);
	//	$st->execute();

//$query = "SELECT * FROM artform WHERE artFormName='$artform'";
//		$result = mysqli_query($con,$query);

		$query2 = "UPDATE `artisan` SET `experience`='$ex' WHERE `id`='$id'";
		$result2 = mysqli_query($con,$query2);
//echo ($org);
		//$st1=$con1->prepare("UPDATE `extras` SET `orgmember`=? WHERE `artisanid`=?");
		//$st1->bind_param("ss", $org, $id);
		//$st1->execute();

		$query3 = "UPDATE `extras` SET `orgmember`='$org' WHERE `artisanid`='$id'";
		$result3 = mysqli_query($con,$query3);
		echo "data uploaded successfully!";

		//$st2=$con->prepare("SELECT * FROM `artform` WHERE `artFormName`=? ");
		//$st2->bind_param("s", $artform);
		//$st2->execute();
		
	//	echo $result;
/*$artformIdd = "";
		if (mysqli_num_rows($result) > 0) {
  // output data of each row
  while($row = mysqli_fetch_assoc($result)) {
  	$artformIdd=$row["id"];
//    echo "id: " . $row["id"];
  }
} else {
  echo "0 results";
}

$st2 = "INSERT INTO `artisanartformrelation` (artisanId, artFormId) VALUES('" . $id . "', '" . $artformIdd . "')";
		$result4 = mysqli_query($con, $st2) ;
		//echo "data uploaded successfully!"; */
		?>