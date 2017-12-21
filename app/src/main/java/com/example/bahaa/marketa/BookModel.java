package com.example.bahaa.marketa;

/**
 * Created by Bahaa on 12/19/2017.
 */

public class BookModel {
    public String bookTitle, bookPrice, bookAuthor;
    public int bookImgRef;

    public String[] summary = {
            "High-class call girls billed to Mastercard. A psychic 13-year-old dropout with a passion for Talking Heads. A hunky matinee idol doomed to play dentists and teachers. A one-armed beach-combing poet, an uptight hotel clerk and one very bemused narrator caught in the web of advanced capitalist mayhem. Combine this offbeat cast of characters with Murakami's idiosyncratic prose and out comes Dance Dance Dance",
            "Sophie finds two questions in her mailbox: \"Who are you?\" and \"Where does the world come from?\" This is the start of her journey through the history of philosophy, guided by a mysterious mentor. To find the truth, we must understand the questions, but the truth is stranger than Sophie can imagine.",
            "Written in 1914 but not published until 1925, a year after Kafka’s death, The Trial is the terrifying tale of Josef K., a respectable bank officer who is suddenly and inexplicably arrested and must defend himself against a charge about which he can get no information. Whether read as an existential tale, a parable, or a prophecy of the excesses of modern bureaucracy wedded to the madness of totalitarianism, The Trial has resonated with chilling truth for generations of readers. ",
            "Sugar Street is the third and concluding volume of the celebrated Cairo Trilogy, which brings the story of Al-Sayid Ahmad and his family up to the middle of the twentieth century.\nAging and ill, the family patriarch surveys the world from his housewares's latticed balcony, as his long-suffering wife once did. While his children face middle age, it is through his grandsons that we see a modern Egypt emerging.",
            "The story of the creation of the world and of the First Age, this is the ancient drama to which the characters in The Lord of the Rings look back and in whose events some of them, such as Elrond and Galadriel, took part.",
            "This well-researched examination of human moral impulses will appeal to liberals and conservatives alike following the 2016 presidential campaign and election.",
            "The critically acclaimed debut novel from Stephen Chbosky, Perks follows observant “wallflower” Charlie as he charts a course through the strange world between adolescence and adulthood. First dates, family drama, and new friends. Sex, drugs, and The Rocky Horror Picture Show. Devastating loss, young love, and life on the fringes. Caught between trying to live his life and trying to run from it, Charlie must learn to navigate those wild and poignant roller-coaster days known as growing up.",
            "The Brothers Karamazov is a passionate philosophical novel set in 19th century Russia, that enters deeply into the ethical debates of God, free will, and morality. It is a spiritual drama of moral struggles concerning faith, doubt, and reason, set against a modernizing Russia."
    };

    public BookModel(String bookTitle, String bookPrice, String bookAuthor, int bookImgRef) {
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
        this.bookImgRef = bookImgRef;
    }

    public BookModel() {
        //Required Empty Constructor
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public int getBookImgRef() {
        return bookImgRef;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookImgRef(int bookImgRef) {
        this.bookImgRef = bookImgRef;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
