import groovy.xml.MarkupBuilder

/**
 * Created by chris on 11/18/14.
 */
class XmlParsingTests extends GroovyTestCase{

    private XML_DATA = "<Languages>" +
            "<Language name=\"C++\">" +
                "<Author>Stroustrup</Author>" +
            "</Language>" +
            "<Language name=\"Java\">" +
                "<Author>Gosling</Author>" +
            "</Language>" +
            "<Language name=\"Lisp\">" +
                "<Author>McCarthy</Author>" +
            "</Language>" +
            "<Language name=\"Pascal\">" +
                "<Author>Wirth</Author>" +
            "</Language>" +
       "</Languages>"
    private workers = ["William": "Footman", "Charlie": "Butler", "John": "Lord's Valet", "Thomas": "First Footman", "Robert": "Lord", "Tom": "Chauffer"]

    void testParse()
    {
        def languages = new XmlParser().parseText(XML_DATA);

        languages.each {
            assertTrue(it.@name != null && it.Author != null)
            println "${it.@name} authored by ${it.Author[0].text()}"
        }
    }

    void testWriteXml()
    {
        def content = ''
        workers.each { Name, Job ->
            def fragment = """\t<Job title="${Job}">\n\t\t<Worker>${Name}</Worker>\n\t</Job>\n"""
            content += fragment
        }
        def xml = "<Jobs>\n${content}</Jobs>"

        println xml
    }

    void testXmlBuilder()
    {
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        builder.Jobs {
            workers.each { key, value ->
                Job(title: value)
                        {Worker(key)}

            }
        }
        println writer
    }
}
