package com.liguang.mytest.word;

import cn.hutool.core.convert.NumberChineseFormatter;
import cn.hutool.core.io.FileUtil;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import com.aspose.words.Document;
import com.aspose.words.FontSettings;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.plugin.table.LoopRowTableRenderPolicy;
import com.google.common.collect.Lists;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.math.BigDecimal;

/**
 * 描述:
 *
 * @author fairy
 * @date 2023/6/26 11:19
 */
@RestController
public class WordController {

    /**
     * 工品猫产品销售合同模板
     */
    @Value("classpath:gpm-sales-contract-template.docx")
    private Resource contractFile;
    /**
     * aspose 证书
     */
    @Value("classpath:license.xml")
    private Resource licenseFile;
    /**
     * 经典宋体简.ttf
     */
    @Value("classpath:simple-song.ttf")
    private Resource fontFile;

    public void docx() {
        // docx
        /*
        XWPFDocument docx = new XWPFDocument(new FileInputStream("/Users/liguang/workspace/projects/myself/mytest/src/main/resources/工品猫产品销售合同919.docx"));
        List<XWPFTable> tables = docx.getTables();
        XWPFTable xwpfTable = tables.get(0);
        xwpfTable.getRow(1).getCell(1).setText("张三");
        docx.write(new FileOutputStream("/Users/liguang/workspace/projects/myself/mytest/src/main/resources/工品猫产品销售合同9191.docx"));
         */
    }

    /*public void doc() {
        String source = "/Users/liguang/workspace/projects/myself/mytest/src/main/resources/工品猫产品销售合同919.doc";
        String target = "/Users/liguang/workspace/projects/myself/mytest/src/main/resources/工品猫产品销售合同9192.doc";
        // doc
        Map<String, String> dataMap = MapUtil.<String, String>builder()
                // 合同编号
                .put("contractNo", "GPM 20230626123456")
                .put("buyerName", "李广")
                .put("concatAddress", "南京市雨花台区新华汇A1栋4楼")
                .put("concatPeople", "李广")
                .put("concatPhone", "17715271312")
                .put("bigTotalPrice", "壹万伍仟陆佰柒拾肆")
                .put("smallTotalPrice", "15674")
                .put("deliveryWay", "到付")
                .put("deliveryFreight", "10")
                .put("chargePeople", "李广")
                .put("tradeAddress", "南京市雨花台区新华汇A1栋4楼")
                .put("tradePeople", "李广")
                .put("tradePhone", "17715271312")
                .put("billTitle", "南京万米信息技术有限公司")
                .put("billNo", "99999999999999")
                .put("billAddress", "南京市雨花台区新华汇A1栋4楼")
                .put("billPhone", "17715271312")
                .put("billBank", "南京银行")
                .put("billBankNo", "857276264572")
                .put("aSign", "李广")
                .put("aSignDate", "20230625")
                .put("bSign", "李广")
                .put("bSignDate", "20230625").build();
        try (FileInputStream fileInputStream = new FileInputStream(source);
             HWPFDocument doc = new HWPFDocument(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream(target);
        ) {
            Bookmarks bookmarks = doc.getBookmarks();
            int bookmarksCount = bookmarks.getBookmarksCount() - 1;
            for (int i = 0; i < bookmarksCount; i++) {
                Bookmark bookmark = bookmarks.getBookmark(i);
                if (dataMap.containsKey(bookmark.getName())) {
                    Range range = new Range(bookmark.getStart(), bookmark.getEnd(), doc);
                    range.replaceText(dataMap.get(bookmark.getName()), false);
                }
            }
            doc.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    @GetMapping("/word-to-pdf")
    public void poiTl() throws Exception {
        String format = NumberChineseFormatter.format(new BigDecimal("2345.11").doubleValue(), true, true);
        Goods goods = Goods.builder().no(1).modelNo("KKK-M18").brandName("苏荷特").num(19).price(new BigDecimal("12.5")).totalPrice(new BigDecimal("12.5").multiply(new BigDecimal(19))).remark("购买").build();
        Goods goods1 = Goods.builder().no(2).modelNo("KKK-M19").brandName("苏荷特").num(17).price(new BigDecimal("11.5")).totalPrice(new BigDecimal("11.5").multiply(new BigDecimal(17))).remark("购买这种").build();
        Goods goods2 = Goods.builder().no(3).modelNo("KKK-M20").brandName("苏荷特").num(15).price(new BigDecimal("15.5")).totalPrice(new BigDecimal("15.5").multiply(new BigDecimal(15))).remark("购买发放").build();
        TradeContract contract = TradeContract.builder()
                // 合同编号
                .contractNo("GPM 20230626123456")
                // 甲方(采购方)
                .buyerName("李广")
                // 联系地址
                .concatAddress("南京市雨花台区新华汇A1栋4楼")
                // 联系人
                .concatPeople("李广")
                // 联系电话
                .concatPhone("17715271312")
                // 合计金额大写
                .bigTotalPrice(format)
                // 合计金额小写
                .smallTotalPrice(new BigDecimal("2345.11"))
                // 运输方式
                .deliveryWay("到付")
                // 运费
                .deliveryFreight(BigDecimal.TEN)
                // 经办人
                .chargePeople("李广")
                // 收货地址
                .tradeAddress("南京市雨花台区新华汇A1栋4楼")
                // 收件人
                .tradePeople("李广")
                // 收件人手机号
                .tradePhone("17715271312")
                // 发票抬头
                .billTitle("南京万米信息技术有限公司")
                // 纳税人识别号
                .billNo("99999999999999")
                // 地址
                .billAddress("南京市雨花台区新华汇A1栋4楼")
                // 电话
                .billPhone("17715271312")
                // 开户行
                .billBank("南京银行")
                // 银行账号
                .billBankNo("857276264572")
                // 甲方经办人签字盖章
                .aSign("李广")
                // 乙方经办人签字盖章
                .bSign("李广")
                // 签订日期
                .signDate("20230625")
                .goods(Lists.newArrayList(goods, goods1, goods2))
                .build();

        LoopRowTableRenderPolicy policy = new LoopRowTableRenderPolicy();
        Configure configure = Configure.builder().bind("goods", policy).build();

        XWPFTemplate template = XWPFTemplate.compile(contractFile.getInputStream(), configure).render(contract);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        template.write(baos);
        InputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
        this.wordToPdf(inputStream, System.getProperty("user.dir") + "/工品猫产品销售合同9192.pdf");
    }


    public static void pdfConverer(String source, String target) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(target);
        XWPFDocument document = new XWPFDocument(fis);
        PdfConverter.getInstance().convert(document, fos, PdfOptions.create());
    }

    public void wordToPdf(InputStream inputStream, String pdfPath) throws Exception {
        this.getLicense();
        try (FileOutputStream os = new FileOutputStream(pdfPath)) {
            Document doc = new Document(inputStream);
            String fontPath = this.getFontPath();
            File file = new File(System.getProperty("user.dir") + File.separator + "simple-song.ttf");
            if (!FileUtil.exist(file)) {
                FileUtils.copyInputStreamToFile(fontFile.getInputStream(), file);
            }
            FontSettings.getDefaultInstance().setFontsFolders(
                    new String[]{fontPath, System.getProperty("user.dir")}, true
            );
            doc.save(os, SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFontPath() {
        OsInfo osInfo = SystemUtil.getOsInfo();
        if (osInfo.isMacOsX()) {
            return "/System/Library/Fonts";
        } else if (osInfo.isLinux()) {
            return "/usr/share/fonts";
        } else if (osInfo.isWindows()) {
            return "C:\\Windows\\Fonts";
        }
        return "";
    }

    public void getLicense() throws Exception {
        License license = new License();
        license.setLicense(licenseFile.getInputStream());
    }

    public static void main(String[] args) throws IOException {
//        poiTl();
    }
}
