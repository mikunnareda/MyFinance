package com.example.myfinances;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
public class FinanceDataSource {
    private SQLiteDatabase database;
    private FinanceDBHelper dbHelper;

    public FinanceDataSource(Context context) {
        dbHelper = new FinanceDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertCD(CD cd) {
        ContentValues values = new ContentValues();
        values.put(FinanceDBHelper.COLUMN_ACCOUNT_NUMBER, cd.getAccountNumber());
        values.put(FinanceDBHelper.COLUMN_INITIAL_BALANCE, cd.getInitialBalance());
        values.put(FinanceDBHelper.COLUMN_CURRENT_BALANCE, cd.getCurrentBalance());
        values.put(FinanceDBHelper.COLUMN_INTEREST_RATE, cd.getInterestRate());

        return database.insert(FinanceDBHelper.TABLE_CD, null, values) > 0;
    }

    public boolean insertLoan(Loan loan) {
        ContentValues values = new ContentValues();
        values.put(FinanceDBHelper.COLUMN_ACCOUNT_NUMBER, loan.getAccountNumber());
        values.put(FinanceDBHelper.COLUMN_INITIAL_BALANCE, loan.getInitialBalance());
        values.put(FinanceDBHelper.COLUMN_CURRENT_BALANCE, loan.getCurrentBalance());
        values.put(FinanceDBHelper.COLUMN_PAYMENT_AMOUNT, loan.getPaymentAmount());
        values.put(FinanceDBHelper.COLUMN_INTEREST_RATE, loan.getInterestRate());

        return database.insert(FinanceDBHelper.TABLE_LOAN, null, values) > 0;
    }

    public boolean insertChecking(Checking checking) {
        ContentValues values = new ContentValues();
        values.put(FinanceDBHelper.COLUMN_ACCOUNT_NUMBER, checking.getAccountNumber());
        values.put(FinanceDBHelper.COLUMN_CURRENT_BALANCE, checking.getCurrentBalance());

        return database.insert(FinanceDBHelper.TABLE_CHECKING, null, values) > 0;
    }
}
