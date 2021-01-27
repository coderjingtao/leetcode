package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: code challenge of bundle calculator
 * Created by Jingtao Liu on 7/03/2019.
 */
public class BundleCalculator {

    /**
     * Solution: backtracking
     */
    public List<Integer> bundleCalculator(int[] bundles, int numberOfItems){
        List<List<Integer>> result = new ArrayList<>();
        if(bundles == null || bundles.length == 0 || numberOfItems <= 0)
            return new ArrayList<>();
        Arrays.sort(bundles);
        generateBundles(bundles,numberOfItems,bundles.length-1,new ArrayList<>(),result);
        return result.get(0);
    }

    private void generateBundles(int[] bundles, int target, int start, List<Integer> bundle, List<List<Integer>> bundleList){
        if( bundleList.size() == 1){
            return;
        }
        if( target == 0 ){
            bundleList.add(new ArrayList<>(bundle));
            return;
        }
        for(int i = start; i >= 0; i--){
            if(bundles[i] <= target){
                bundle.add(bundles[i]);
                generateBundles(bundles,target-bundles[i],i,bundle,bundleList);
                bundle.remove(bundle.size()-1);
            }
        }
    }

    //test cases
    public static void main(String[] args) {
        BundleCalculator calculator = new BundleCalculator();
        //IMG
        int[] image_bundles = {5,10};
        int image_number = 10;
        List<Integer> image_result = calculator.bundleCalculator(image_bundles,image_number);
        System.out.println(image_number+" IMG:"+image_result.toString());
        //FLAC
        int[] audio_bundles = {3,6,9};
        int audio_number = 15;
        List<Integer> audio_result = calculator.bundleCalculator(audio_bundles,audio_number);
        System.out.println(audio_number+" FLAC:"+audio_result.toString());
        //VID
        int[] video_bundles = {3,5,9};
        int video_number = 13;
        List<Integer> video_result = calculator.bundleCalculator(video_bundles,video_number);
        System.out.println(video_number+" VID:"+video_result.toString());
    }
}
