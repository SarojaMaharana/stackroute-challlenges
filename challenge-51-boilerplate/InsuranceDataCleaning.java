import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public class InsuranceDataCleaning {
    public static void main(String[] args) {
        InsuranceDataReader idr = new InsuranceDataReader("sample.csv");
        List<InsuranceData> insuranceDataList = idr.getInsuranceDataList();
        Function<List<InsuranceData>, String> highestRegionFunction = (id) -> {
            Set<String> regions = new HashSet<>();
            HashMap<String, Integer> regionsWithOccurance = new HashMap<>();
            int max = 0;

            for(InsuranceData i:id)
                regions.add(i.getRegion());
            for(String str:regions){
                int count = 0;
                for(InsuranceData i:id){
                    if(str.equalsIgnoreCase(i.getRegion()))
                        count++;
                }
                if(max < count)
                    max = count;
                regionsWithOccurance.put(str, count);
            }
            for(String key:regionsWithOccurance.keySet()){
                if(max == regionsWithOccurance.get(key))
                    return key;
            }
            return null;
        };
        Supplier<String> highestRegionSupplier = () -> highestRegionFunction.apply(insuranceDataList);
        // Supplier<AgeZeroException> ageException = () -> new AgeZeroException();

        for(InsuranceData i:insuranceDataList){
            Optional<String> regionOption = Optional.ofNullable(i.getRegion());
            if(regionOption.isEmpty())
                i.setRegion(highestRegionSupplier);

            // Optional<Integer> ageOption = Optional.ofNullable(i.getAge());
            OptionalInt ageOption = OptionalInt.of(i.getAge());
            try{
                if(ageOption.getAsInt() == 0)
                    throw (new AgeZeroException());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
