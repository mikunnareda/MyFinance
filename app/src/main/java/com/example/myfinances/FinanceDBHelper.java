package com.example.myfinances;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class FinanceDBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "MyFinances.db";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    public static final String TABLE_CD = "cd";
    public static final String TABLE_LOAN = "loan";
    public static final String TABLE_CHECKING = "checking";

    // Common Column
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ACCOUNT_NUMBER = "account_number";

    // CD Table Columns
    public static final String COLUMN_INITIAL_BALANCE = "initial_balance";
    public static final String COLUMN_CURRENT_BALANCE = "current_balance";
    public static final String COLUMN_INTEREST_RATE = "interest_rate";

    // Loan Table Columns
    public static final String COLUMN_PAYMENT_AMOUNT = "payment_amount";

    // Checking Table Columns (Only Account Number and Current Balance)

    private static final String CREATE_TABLE_CD = "CREATE TABLE " + TABLE_CD + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_ACCOUNT_NUMBER + " TEXT, " +
            COLUMN_INITIAL_BALANCE + " REAL, " +
            COLUMN_CURRENT_BALANCE + " REAL, " +
            COLUMN_INTEREST_RATE + " REAL);";

    private static final String CREATE_TABLE_LOAN = "CREATE TABLE " + TABLE_LOAN + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_ACCOUNT_NUMBER + " TEXT, " +
            COLUMN_INITIAL_BALANCE + " REAL, " +
            COLUMN_CURRENT_BALANCE + " REAL, " +
            COLUMN_PAYMENT_AMOUNT + " REAL, " +
            COLUMN_INTEREST_RATE + " REAL);";

    private static final String CREATE_TABLE_CHECKING = "CREATE TABLE " + TABLE_CHECKING + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_ACCOUNT_NUMBER + " TEXT, " +
            COLUMN_CURRENT_BALANCE + " REAL);";

    public FinanceDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CD);
        db.execSQL(CREATE_TABLE_LOAN);
        db.execSQL(CREATE_TABLE_CHECKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHECKING);
        onCreate(db);
    }
}
