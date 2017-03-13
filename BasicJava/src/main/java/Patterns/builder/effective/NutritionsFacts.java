package Patterns.builder.effective;

/**
 * Created by Steve on 2017/3/13.
 */
public class NutritionsFacts {

    private final int servingSize;
    private final int servings;

    private final int fat;

    private final int sodium;


    private NutritionsFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        fat = builder.fat;
        sodium = builder.sodium;
    }


    public static class Builder {
        // required params
        private final int servingSize;
        private final int servings;

        // optional params
        private int fat;
        private int sodium;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public NutritionsFacts build() {
            return new NutritionsFacts(this);
        }
    }

    public static void main(String[] args) {
        NutritionsFacts nutritionsFacts = new Builder(240, 8).fat(100).sodium(35).build();

    }

}
