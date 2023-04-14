case class PhonemicString(strt: String):
    	// List(List("A", "ɑ"), List("@", "ə"), List("E", "ɛ"), List("ae", "æ"), List("I", "ɪ"), List("i", "i"), List("O", "ɔ"), List("o", "o"), List("U", "ʊ"), List("u", "u"), List("3", "ɜ"), List("6", "ɐ"), List("7", "ɨ"), List("8", "ɵ"), List("9", "ɘ"), List("&", "æ"), List("@`", "ɚ"))
	var caseList = List(List('@','ə'),List('E','ɛ'))  //expand for all 30 characters
	var unitList = List("tʃ", "dʒ", "ː")              //expand for all affricates
	var strIpa = strt
	var strXsampa = strt
	

	var i = 0;
	while(i < caseList.length){
    		var tempL = caseList(i)
    		strIpa = strIpa.replace(tempL(0),tempL(1))
    		i = i + 1
  		}

	i = 0;
	while(i < caseList.length){
    		var tempL = caseList(i)
    		strXsampa = strXsampa.replace(tempL(1),tempL(0))
    		i = i + 1
  		}

	var plength = strIpa.length()
	var count = 0;
	i = 0;
	while(i < unitList.length){
    		count = count + strt.sliding(unitList(i).length()).count(_ == unitList(i))
    		i = i + 1
  		}
	plength = plength - count;


	def toIPACase = strIpa
	def toXSampaCase = strXsampa
	def length = plength

	override def toString = strIpa

	def =~(newStr: PhonemicString) = (strIpa == newStr.strIpa)

given Conversion[String,PhonemicString] = n => PhonemicString(n)
extension (s: String)
	def / = PhonemicString(s)

//var d = \hE:loU\
var g = "he"
PhonemicString("he") =~ g
"he" =~ g

"he" /

var d = "<hE:l@>"
var dx = "<hɛ:lə>"
d =~ dx

var gps = PhonemicString("heːtʃ tʃyuʃt")
gps.length

//in progress loop strucure
def loop_each_word (word: => String) (sentence: => String) (body: => Unit) =
	val arr = sentence.split("[ -]")
	for(word <- arr){
  		body
  	}

loop_each_word (w) ("hE:lo-hE:loU-hE:loU") {
	println(w)
}




//-------------------------------
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

extension (s: String)
	def u = unorderedString(s)


var g2 = "i am lord voldemort"
var g3 = "i amd lordvv volodemort lloaer "
var us1 = "tom marvolo riddle "
var us2 = "tik" u

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


var g2 = "i am lord voldemort"
var us1 = unorderedString("tom marvolo riddle ")
us1 ~~ g2



def for_loop(initializer: => Unit, condition: => Boolean, increment: => Unit)(body: => Unit) = {
    initializer
    while (condition) {
      body
      increment
    }
  }

def for_loop(condition: => Int)(body: => Unit) = {
    i = 0
    while (i < condition) {
      body
      i += 1
    }
  }

def for_loop(cond: => Boolean, increment: => Unit)(body: => Unit) = {
    i = 0
    while (cond) {
      body
      increment
    }
  }

var i = 0;
for_loop(10) {
  println(i)
}

for_loop(i < 10, i += 1) {
  println(i * 2)
}

for_loop((i = 0), i < 10, i += 1) {
  println(i);
}
