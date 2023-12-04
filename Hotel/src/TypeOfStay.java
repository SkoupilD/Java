public enum TypeOfStay {
    WORKING("Working"), HOLIDAY("Holiday");
    final String description;
    TypeOfStay(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return  description;
    }
}
