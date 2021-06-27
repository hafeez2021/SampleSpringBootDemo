package com.dp.demo.utils;

import com.dp.demo.contracts.PersistenceRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class TestFileSetupHelper {


    public static void purgeStepsDataFromDB(PersistenceRepository persistenceRepository, String schemaName) {
    purgeDb(persistenceRepository, schemaName, new String[] { schemaName + ".steps", schemaName + ".steps",
            schemaName});
    }

    public static void purgeDb(PersistenceRepository persistenceRepository, String schemaName, String[] tableNames) {
        for (String tableName : tableNames) {
            String schemaPrefix = schemaName + '.';
            String fullTableName = tableName.startsWith(schemaPrefix) ? tableName : schemaPrefix + tableName;
            String dropTableSQL;

            dropTableSQL = persistenceRepository.dropTableQueryIfExists(fullTableName);
            persistenceRepository.execute(dropTableSQL);
        }
        String dropSchemaSQL = persistenceRepository.dropSchemaIfExists(schemaName);
        persistenceRepository.execute(dropSchemaSQL);
    }

    private static final Random RANDOM = new Random(1234567890L);
    private static final char[] NRIC_FIRST_CHARS = new char[] { 'S', 'F', 'T', 'G' };
    public static final String LAST_CHARS_FOR_NRIC = "JZIHGFEDCBA";
    public static final String LAST_CHAES_FOR_FIN = "XWUTRQPNMLK";
    public static String getRandomNRIC() {
        char firstChar = NRIC_FIRST_CHARS[RANDOM.nextInt(NRIC_FIRST_CHARS.length)];
        String numberPart = String.format("%07d", RANDOM.nextInt(4000000));
        int[] multiples = { 2, 7, 6, 5, 4, 3, 2 };
        int weight = 0;
        for (int i = 0; i < 7; i++) {
            weight += Character.getNumericValue(numberPart.charAt(i)) * multiples[i];
        }
        int offset = (firstChar == 'T' || firstChar == 'G') ? 4 : 0;
        int lastCharIndex = (offset + weight) % 11;
        char lastChar;
        if (firstChar == 'S' || firstChar == 'T') {
            lastChar = LAST_CHARS_FOR_NRIC.charAt(lastCharIndex);
        } else {
            lastChar = LAST_CHAES_FOR_FIN.charAt(lastCharIndex);
        }
        return (firstChar + numberPart + lastChar);
    }
}
