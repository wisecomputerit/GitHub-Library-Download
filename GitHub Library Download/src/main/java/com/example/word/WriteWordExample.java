package com.example.word;

/**
 * Hello world!
 *
 */
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import book.booktitle;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteWordExample {
    public static void main(String[] args) {
    	
    	  String[] textmessage = {"Book1", "Book2", "Book3"};
    
    	 String[] Book_related = getBook_title_related(textmessage);

        XWPFDocument document = new XWPFDocument();
        
        // 創建段落並格式化輸出
        createParagraph(document, "Wise Courses Ltd.", true);  // 標題 品牌
       
        for (int i = 0; i < Book_related.length; i++) {
        	
            createParagraph(document, Book_related[i], false);  // 每個書籍相關的描述
            
            
        }

        
        
        
        
        
        
        
        
        
        // 創建一個新的文檔
        try (FileOutputStream out = new FileOutputStream("test.docx")) {
            document.write(out);
            System.out.println("Word file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    
    

    // Book_title_related = 3
    public static String[] getBook_title_related(  String[] book_relatedR) {
    	
    	
        String[] book_related = new String[3];
    	
    	
    	
    	
        booktitle book_title = book.booktitle.VALUE1;
        booktitle theme = book.booktitle.VALUE2;
        booktitle author = book.booktitle.VALUE3;

        // 如果需要其描述，可以使用 getDescription()
        String descriptionAsString = book_title.getDescription();
        System.out.println("book title : " + descriptionAsString);  // 輸出 "First value"
        book_related[0] = descriptionAsString;

        String themeBOOK = theme.getDescription();
        System.out.println("themeBOOK title : " + themeBOOK);  // 輸出 "First value"
        book_related[1] = themeBOOK;

        String author_book = author.getDescription();
        System.out.println("author_book title : " + author_book);  // 輸出 "First value"
        book_related[2] = author_book;

      
        
        
        String[] BOOK = gettext_message(book_related,book_relatedR);
        
        
        return BOOK;
    }
    
    
    

    
    
    // 創建段落的輔助方法
    public static void createParagraph(XWPFDocument document, String text, boolean isHeading) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        // 設置標題的樣式（如果是標題）
        if (isHeading) {
            run.setBold(true);
            run.setFontSize(16);
        } else {
            run.setFontSize(12);
        }
        
        run.setText(text);
    }

    
    
    
    
    public static String [] gettext_message(String [] name,String [] book_related)
    {

    	
        // 創建一個新的陣列，其大小是兩個陣列的總和
        String[] mergedArray = new String[name.length + book_related.length];

        // 將 name 陣列的元素複製到 mergedArray 中
        System.arraycopy(name, 0, mergedArray, 0, name.length);

        // 將 book_related 陣列的元素複製到 mergedArray 中
        System.arraycopy(book_related, 0, mergedArray, name.length, book_related.length);

        // 輸出結果
        for (String item : mergedArray) {
      //      System.out.println("item = "+item);
        }

	
	
    	
    	return mergedArray;
    }
    
    
    
    
    
    
    
}
