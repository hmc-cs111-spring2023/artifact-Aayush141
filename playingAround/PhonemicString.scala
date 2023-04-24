case class PhonemicString(var strt: String):
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


var g = "he"
PhonemicString("he") =~ g
"he" =~ g

var d = "<hE:l@>"
var dx = "<hɛ:lə>"
d =~ dx

var gps = PhonemicString("heːtʃ tʃyuʃt")
gps.length
