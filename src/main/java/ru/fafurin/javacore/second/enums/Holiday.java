package ru.fafurin.javacore.second.enums;

public enum Holiday {
    NEW_YEAR("31.12", "Happy New Year! I wish that this year will give you many reasons for joy and happy moments. " +
            "May your cherished desires come true, may luck accompany you in all your affairs! Leave all the hardships behind" +
            " and this New Year's Eve believe in a miracle, because when you believe in something, it definitely comes true!"),
    MARCH8("08.03", "On this bright spring holiday, I would like to wholeheartedly congratulate " +
            "you on International Women's Day and wish you the most important and priceless things: health, love and simple human happiness."),
    FEBRUARY23("23.02", "Our dear men, our brave and courageous defenders! You are our support, hope and protection! " +
            "Congratulations on Defender of the Fatherland Day! Dear, beloved, dear ones, thank you for your courage, responsibility and reliability.");

    private final String value;
    private final String text;

    Holiday(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }


}
