import pppp._

object TestApp {
  @main
  def main(args: Array[String]): Unit = {
    "TEST STARTS HERE"↓

    3 lines

    // Compare two phonemic strings for equality and print "case match" if they are equal
    ("/hE:l@/" =~ "/hɛ:lə/") -> ("case match"↓)

    1 line

    var ana1 = Array("i am lord voldemort", "emotio", "hullabaloo")
    var ana2 = "tom marvolo riddle "

    // Check if two unordered strings are equal in a loop, and print "Anagram Found!" if they are
    3 times {
      (ana1(i) ~~ ana2) -> ("Anagram Found!"↓)
    }

    1 line

    // Check if an unordered string is a subset of another and print "Subset Found!" if it is
    3 times {
      (ana1(i) ⊆ ana2) -> ("Subset Found! "↓)
    }

    // Create and manipulate a PhonemicString to print and change cases

    var tst = "hE:lə "/

    1 line

    tst↓

    tst↓|

    tst↓×

    tst toIPACase

    // Create a PhonemicString and get its length
    var phoneme = PhonemicString("heːtʃ tʃy@ʃt")
    phoneme length

    // Check if one unordered string is a superset of the difference between two other unordered strings
    "lol kitty" ⊇ ("hello keith" - "hehe")

    var uo1 = "tik"u

    uo1 = ana2 + uo1
    uo1
    uo1 ? 'o'
    uo1.length()

    ()ln

    false -> ("hullabaloo"↓)

    1 line

    // Various for_loop examples with different initializers and increments
    var i = 0;
    for_loop(10) {
      println(i)
    }

    2 lines

    for_loop(i < 10, i += 1) {
      println(i * 2)
    }

    2 lines

    for_loop((i = 0), i < 10, i += 1) {
      println(i);
    }

    uo1 frequencyOf 'd'
  }
}

