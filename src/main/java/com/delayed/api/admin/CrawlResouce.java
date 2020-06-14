package com.delayed.api.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.delayed.model.PostModel;
import com.google.gson.Gson;

@WebServlet("/api/crawl-data")
public class CrawlResouce extends HttpServlet {
	private static final long serialVersionUID = -8420029052090907334L;
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String url = "https://vnexpress.net/";
		Document doc = Jsoup.connect(url).get();
		ArrayList<String> el = new ArrayList<String>();
		Elements linksDOM = doc.getElementsByTag("a");
		Set<String> set = new LinkedHashSet<String>();
		for (Element link : linksDOM) {
			if (link.attr("href").contains("https://vnexpress.net/")
					&& !link.attr("href").contains("#box_comment_vne")) {
				el.add(link.attr("href").toString());
			}
		}
		set.addAll(el);
		el.clear();
		el.addAll(set);
		ArrayList<PostModel> vnExpress = new ArrayList<PostModel>();
		for (String str : el) {
			Document document = Jsoup.connect(str).get();
			String title = document.getElementsByClass("title-detail").text();
			String description = document.getElementsByClass("description").text();
			String content = document.getElementsByClass("description").html();
//			LocalDateTime date = LocalDateTime.parse(document.getElementsByClass("date").text());
//			String category = document.select("a[data-medium~=Menu\\]").html();
			if (!title.isEmpty() && title != null) {
				PostModel post = new PostModel();
				post.setTitle(title);
				post.setDescription(description);
				post.setContent(content);
//				post.setDate(date);
//				post.setCategory(category);
				vnExpress.add(post);
			}
		}
		out.print(this.gson.toJson(vnExpress));
		out.flush();
	}
}
