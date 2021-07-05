@Grab('org.apache.pdfbox:pdfbox:2.0.22')
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper

println "pdf2txt"
println "======="
filename = args[0]
pdf = "${filename}.pdf"
txt = "${filename}.txt"
println "Extracting text from $pdf and saving in $txt"
File file = new File(pdf)
PDDocument document = PDDocument.load(file)
PDFTextStripper stripper = new PDFTextStripper()
String text = stripper.getText(document)
new File(txt).withWriter('utf-8') {
    writer -> writer.write(text)
}
document.close()
