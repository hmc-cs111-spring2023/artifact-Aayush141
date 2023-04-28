import pppp._

"TEST STARTS HERE"↓

3 lines

("/hE:l@/" =~ "/hɛ:lə/") -> ("case match"↓)

1 line

3 times {
  (ana1(i) ~~ ana2) -> ("Anagram Found!"↓)
}

1 line

3 times {
  (ana1(i) ⊆ ana2) -> ("Subset Found! "↓)
}

var tst = "hE:lə "/

1 line

tst↓

tst↓|

tst↓×

tst toIPACase

var phoneme = PhonemicString("heːtʃ tʃy@ʃt")
phoneme length

"lol kitty" ⊇ ("hello keith" - "hehe")

var ana1 = Array("i am lord voldemort", "emotio", "hullabaloo")
var ana2 = "tom marvolo riddle "
var uo1 = "tik"u

uo1 = ana2 + uo1
uo1
uo1 ? 'o'
uo1.length()

()ln

false -> ("hullabaloo"↓)

1 line

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
