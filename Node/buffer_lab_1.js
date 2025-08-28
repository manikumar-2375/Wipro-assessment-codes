// buffer_lab.js

// 1) Create a Buffer of size 256 bytes
const buf = Buffer.alloc(256);

// 2) Write first student as compact JSON (plus newline so we can append more)
const student1 = { id: 1, name: "Thananya", age: 20, grade: "A" };
const s1Json = JSON.stringify(student1);      // -> {"id":1,"name":"Thananya","age":20,"grade":"A"}
const s1Line = s1Json + "\n";                 // add newline so total bytes = 47 + 1 = 48

// Write at offset 0 using utf8
const bytesWritten1 = buf.write(s1Line, 0, "utf8");

// Display bytes written (should be 48)
console.log("Bytes written to buffer:", bytesWritten1);

// Show buffer content as a string (trim the newline just for display)
console.log("Buffer content as string:", s1Json);

// 3) Read Data from Buffer (parse first line)
const usedSoFar = bytesWritten1;
const allUsedStr = buf.toString("utf8", 0, usedSoFar); // includes the newline
const firstLine = allUsedStr.split("\n")[0];           // take the first JSON line
const parsed = JSON.parse(firstLine);

console.log("Parsed Student Data:");
console.log("ID:", parsed.id);
console.log("Name:", parsed.name);
console.log("Age:", parsed.age);
console.log("Grade:", parsed.grade);

// 4) Append another student if space permits
const student2 = { id: 2, name: "Rahul", age: 21, grade: "B" };
const s2Json = JSON.stringify(student2);
const s2Line = s2Json + "\n";

let totalUsed = usedSoFar;
const s2BytesNeeded = Buffer.byteLength(s2Line, "utf8");

if (totalUsed + s2BytesNeeded <= buf.length) {
  const bytesWritten2 = buf.write(s2Line, totalUsed, "utf8"); // write at the end of first
  totalUsed += bytesWritten2;
  console.log("\nAppended second student. Bytes written for s2:", bytesWritten2);
} else {
  console.log("\nNot enough space to append second student.");
}

// 4a) Slice the buffer to read only the first student (up to newline)
const newlineIndex = buf.indexOf("\n", 0, "utf8"); // position of first '\n'
const firstStudentSlice = buf.slice(0, newlineIndex); // slice excludes the newline
const firstStudentStr = firstStudentSlice.toString("utf8");
console.log("\nFirst student (via slice):", firstStudentStr);

// 4b) Copy data from one buffer to another (copy all used bytes)
const copyBuf = Buffer.alloc(256);
buf.copy(copyBuf, 0, 0, totalUsed);
console.log("Copied buffer content (all used bytes):");
console.log(copyBuf.toString("utf8", 0, totalUsed));

// 5) Encoding & Decoding demonstrations

// utf8 -> base64
const base64OfS1 = Buffer.from(s1Json, "utf8").toString("base64");
console.log("\nBuffer content in base64:");
console.log(base64OfS1);

// base64 -> utf8 (round-trip)
const backToUtf8 = Buffer.from(base64OfS1, "base64").toString("utf8");
console.log("Base64 decoded back to utf8:", backToUtf8);

// ascii write/read (safe here because characters are plain ASCII)
const asciiBuf = Buffer.alloc(256);
const asciiBytes = asciiBuf.write(s1Json, 0, "ascii");
const asciiReadBack = asciiBuf.toString("ascii", 0, asciiBytes);
console.log("\nASCII write/read:");
console.log("ASCII bytes written:", asciiBytes);
console.log("ASCII read back:", asciiReadBack);

// Notes:
// - utf8 is preferred for general text. ascii will corrupt non-ASCII characters.
// - base64 is an encoding for safely transporting binary/text data as ASCII.
