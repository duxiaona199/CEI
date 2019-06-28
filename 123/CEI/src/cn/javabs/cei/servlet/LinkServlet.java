package cn.javabs.cei.servlet;



import cn.javabs.cei.entity.Link;
import cn.javabs.cei.service.LinkService;
import cn.javabs.cei.service.impl.LinkServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet( "/linkServlet")
@MultipartConfig(maxFileSize = 1024*1024*50)
public class LinkServlet extends HttpServlet {


    LinkService linkService=  new LinkServiceImpl();
    Link link = new Link();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                     doGet(request ,response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               // LinkService linkService= (LinkService) new LinkServiceImpl();//实例化

               // linkService.findAllLink();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
              String op = request.getParameter("op");//接收前台传递参数

             if ("addLink".equals(op)){
                 addLink(request ,response );
             }else if ("updateLink".equals(op)){
                 updateLink(request ,response );
             }else if ("delLink".equals(op)){
                 delLink(request ,response );
             }else if ("findAllLinks".equals(op)){
                 findAllLinks(request ,response );
             }else if ("editLink".equals(op)){
                 editLink(request ,response );
             }else if ("goToAddLinkView".equals(op)){
                 goToAddLinkView(request ,response );
             }

             else {
                 System.out.println("参数传递有误");
             }

    }
       //添加页面
    private void goToAddLinkView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/admin/addLink.jsp").forward(request ,response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void addLink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path=this.getServletContext().getRealPath("upload/");
        System.out.println("path:"+path); //打印是在idea后台打印出来的 如果打印出来了表示在代码运行成功

        File mainDir = new File(path);//创建多级目录
        if (!mainDir.exists()){
            mainDir.mkdirs();
        }
        Part part=request.getPart("path");//part获取文件
        String fileName=part.getSubmittedFileName();

        if (!fileName.equals("") || fileName != null){;
            String name = UUID.randomUUID().toString();
            System.out.println("name:"+name);
            if (fileName.contains(".")){
                int index = fileName.indexOf(".");
                String newName = fileName.substring(index);
                System.out.println("newName:"+newName);
                fileName =  name +newName;
            }
        }
        System.out.println("fileName:" + fileName);

        part.write(path+"/"+fileName);

        link.setName(fileName);
        link.setPath(path);

//往上是新加的

        BenUtils.populate(link,request.getParameterMap());
        int rows = linkService.addLink(link);

        if (rows>0){
            request.setAttribute("msg","success");
            request.getRequestDispatcher("/message.jsp").forward(request ,response);
        }else {
            request.setAttribute("msg","error");
            request.getRequestDispatcher("/message.jsp").forward(request ,response);
        }
    }


    //修改用户
    private void updateLink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int linkId = Integer.parseInt(id);
        Link link = new Link();
        try{
            link.setId(linkId);
            BenUtils.populate(link,request.getParameterMap());

        }catch (Exception e){
            throw new RuntimeException(e);
        }


        int rows = linkService.updateLink(link);

        if (rows>0){
            request.setAttribute("msg","success");
            request.getRequestDispatcher("/message.jsp").forward(request ,response);
        }else {
            request.setAttribute("msg","error");
            request.getRequestDispatcher("/message.jsp").forward(request ,response);
        }


    }
    private void delLink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println("109id _______:"+id);

        int linkId = Integer.parseInt(id);
        int rows = linkService.delLink(linkId);

        if (rows>0){
            request.setAttribute("msg","success");
            request.getRequestDispatcher("/message.jsp").forward(request ,response);
        }else {
            request.setAttribute("msg","error");
            request.getRequestDispatcher("/message.jsp").forward(request ,response);
        }
    }
    private void findAllLinks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Link> list = linkService.findAllLink();

        if(list != null || list.size() > 0){

            request.setAttribute("list",list);
            request.getRequestDispatcher("/admin/LinkList.jsp").forward(request ,response);
        }else{
            request.setAttribute("msg","error");
            request.getRequestDispatcher("/message.jsp").forward(request ,response);
        }


    }
    private void editLink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("id:"+id);
        int linkId = Integer.parseInt(id);
        System.out.println("LinkId:"+linkId);
        Link link =linkService.findLinkById(linkId);

        if (link !=null){
            request.setAttribute("link",link);
            request.getRequestDispatcher("/admin/updateLink.jsp").forward(request ,response);
        }else {
            request.setAttribute("msg","error");
            request.getRequestDispatcher("/message.jsp").forward(request ,response);
        }

    }
}
