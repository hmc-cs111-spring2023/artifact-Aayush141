// unorderedString -- the characters in the string are not ordered, per say. 

case class unorderedString(strt: String):

	var strArr = (strt.toCharArray()).sorted
	var strArrDist = strArr.distinct

	override def toString = strArr.mkString("")

	def ~~(newStr: unorderedString) = (strArr.sameElements(newStr.strArr))
	def ~~=(newStr: unorderedString) = (strArrDist.sameElements(newStr.strArrDist))

	def -(newStr: unorderedString) = (unorderedString(((strArr).diff(newStr.strArr)).mkString("")))

	def ⊆(newStr: unorderedString) = (strArrDist.diff(newStr.strArrDist).isEmpty)
	def ⊇(newStr: unorderedString) = ((newStr.strArrDist).diff(strArrDist).isEmpty)


given Conversion[String,unorderedString] = n => unorderedString(n)
given Conversion[unorderedString, String] = n => n.toString


var g2 = "i am lord voldemort"
var g3 = "i amd lordvv volodemort lloaer "
var us1 = "tom marvolo riddle "
var us2 = unorderedString("tik")

us1 ~~ g2
us1 ~~= g2
us1 ~~ g3
us1 ~~= g3

"tik" ⊆ "keith"
us1 ⊆ " qwertyuiopasdfghjklzxcvbnm"


us2 = us1 + us2
us2

us1.length()

"hellohe" - "hehe"
