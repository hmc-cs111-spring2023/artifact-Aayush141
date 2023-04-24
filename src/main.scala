// Unordered String

case class unorderedString(strt: String):

	var strArr = (strt.toCharArray()).sorted
	var strArrDist = strArr.distinct

	override def toString = strArr.mkString("")

	def ~~(newStr: unorderedString) = (strArr.sameElements(newStr.strArr))
	def ~~=(newStr: unorderedString) = (strArrDist.sameElements(newStr.strArrDist))

	def -(newStr: unorderedString) = (unorderedString(((strArr).diff(newStr.strArr)).mkString("")))

	def ⊆(newStr: unorderedString) = (strArrDist.diff(newStr.strArrDist).isEmpty)
	def ⊇(newStr: unorderedString) = ((newStr.strArrDist).diff(strArrDist).isEmpty)

	def ?(chars: Char) = strArr.groupBy(identity).mapValues(_.size)(chars)
	def frequencyOf(chars: Char) = strArr.groupBy(identity).mapValues(_.size)(chars)



given Conversion[String,unorderedString] = n => unorderedString(n)
given Conversion[unorderedString, String] = n => n.toString

extension (s: String)
	def u = unorderedString(s)
  
// Phonemic String

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
	def ↓ = print(strt)
	def ↓| = print(strIpa)
	def ↓× = print(strXsampa)

	override def toString = strIpa

	def =~(newStr: PhonemicString) = (strIpa == newStr.strIpa)
	def ~=(newStr: PhonemicString) = (strIpa == newStr.strIpa)
  
	

given Conversion[String,PhonemicString] = n => PhonemicString(n)

extension (s: String)
	def / = PhonemicString(s)

extension (u: Unit)
	def ln = println("")

extension (i: Int)
	def lines = for_loop(i){println("")}
  
// flow control

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
  
extension(b: Boolean)
	def ⊢(statement: => Unit) = if (b) {statement}
	def ->(statement: => Unit) = if (b) {statement}
	def ->(statement: => Unit, elsestatement: => Unit) = if (b) {statement} else {elsestatement}

extension(i2: Int)
	def times(body: => Unit) = for_loop (i2) {body}

  
