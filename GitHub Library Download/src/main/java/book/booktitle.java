package book;

// 定義枚舉類型 booktitle
public enum booktitle {
    VALUE1("First value"),
    VALUE2("Second value"),
    VALUE3("Third value");

    private String description;

    // 構造函數，用來初始化每個枚舉常量的 description
    booktitle(String description) {
        this.description = description;
    }

    // 獲取 description 的方法
    public String getDescription() {
        return description;
    }
}

// 測試調用的類
class EnumWithMethodExample {
    public static void main(String[] args) {
        // 遍歷枚舉並打印描述
        for (booktitle su : booktitle.values()) {
            System.out.println(su + ": " + su.getDescription());
        }

        // 直接調用 VALUE1 並獲取它的描述
        booktitle value1 = booktitle.VALUE1;
        System.out.println("Description of VALUE1: " + value1.getDescription());
    }
}
