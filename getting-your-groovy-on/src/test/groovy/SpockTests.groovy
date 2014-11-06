import spock.lang.Specification

/**
 * Created by chris on 10/4/14.
 */
class SpockTests extends Specification {

    def "Groovy Map.collect example"()
    {
        setup:
        def workers = [William: "Footman", Charlie: "Butler", John: "Lord's Valet", Thomas: "First Footman", Robert: "Lord", Tom: "Chauffer"]

        when:
        def actual = workers.collect() { name, occupation -> "$name is a fine $occupation at Downton Abbey" }

        then:
        actual.size() == 6
        actual[0] == "William is a fine Footman at Downton Abbey"
    }

    def "Groovy Map.each example"()
    {
        setup:
        def workers = [William: "Footman", Charlie: "Butler", John: "Lord's Valet", Thomas: "First Footman", Robert: "Lord", Tom: "Chauffer"]
        def actual = []
        when:

        workers.each(){ entry -> actual << "$entry.key is a fine $entry.value at Downton Abbey" }

        then:
        actual.size() == 6
        actual[0] == "William is a fine Footman at Downton Abbey"
    }

    def "Groovy times example"()
    {
        setup:
        def counter = 0;
        when:
        10.times { counter++}
        then:
        counter == 10;
    }

    def "Groovy Step example"()
    {
        setup:
        def counter = 0
        when:
        0.step(10,2,{ counter ++ })
        then:
        counter == 5
    }
}