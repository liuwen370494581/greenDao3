package end.liuwen.com.greendao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import end.liuwen.com.greendao.Entity.student;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STUDENT".
*/
public class studentDao extends AbstractDao<student, Long> {

    public static final String TABLENAME = "STUDENT";

    /**
     * Properties of entity student.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Age = new Property(2, String.class, "age", false, "AGE");
        public final static Property Number = new Property(3, String.class, "number", false, "NUMBER");
        public final static Property Score = new Property(4, String.class, "score", false, "SCORE");
    }


    public studentDao(DaoConfig config) {
        super(config);
    }
    
    public studentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STUDENT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"AGE\" TEXT," + // 2: age
                "\"NUMBER\" TEXT," + // 3: number
                "\"SCORE\" TEXT);"); // 4: score
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STUDENT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, student entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(3, age);
        }
 
        String number = entity.getNumber();
        if (number != null) {
            stmt.bindString(4, number);
        }
 
        String score = entity.getScore();
        if (score != null) {
            stmt.bindString(5, score);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, student entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String age = entity.getAge();
        if (age != null) {
            stmt.bindString(3, age);
        }
 
        String number = entity.getNumber();
        if (number != null) {
            stmt.bindString(4, number);
        }
 
        String score = entity.getScore();
        if (score != null) {
            stmt.bindString(5, score);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public student readEntity(Cursor cursor, int offset) {
        student entity = new student( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // age
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // number
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // score
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, student entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAge(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setNumber(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setScore(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(student entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(student entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(student entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
